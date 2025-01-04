Single page apps unlike traditional apps fetch from the server all the pages at once unlike a traditional app which would have to fetch different pages when appropriate and redirecting. Single page apps fetch one html page and uses javascript to manipulate.

``
```js
var notes = [] // initalize variable to hold parsed data from rec json

// declare redrawNotes func that uses notes to create most updated list
var redrawNotes = function() { 
  var ul = document.createElement('ul') //create unorder list element
  ul.setAttribute('class', 'notes') //give it class attr notes

  notes.forEach(function (note) { //call func to iterate over each note
    var li = document.createElement('li') //create list item

    ul.appendChild(li); //add it to unordered 
    li.appendChild(document.createTextNode(note.content)) //give list item data
  })

// save reference to div with element notes
  var notesElement = document.getElementById("notes") 
  if (notesElement.hasChildNodes()) { //if it contains anything
    notesElement.removeChild(notesElement.childNodes[0]); //remove
  }
  notesElement.appendChild(ul) //add the initalized unordered list
}

var xhttp = new XMLHttpRequest() //declare xhttp obj to handle network comms

xhttp.onreadystatechange = function () { // declare call back func
  if (this.readyState == 4 && this.status == 200) { //once completed and rdy
    notes = JSON.parse(this.responseText)  // parse the receieved notes
    redrawNotes() //call redrawNotes() declared up/earlier
  }
}

//create a get request and send it to /example/app/data.json
xhttp.open("GET", "/exampleapp/data.json", true)
xhttp.send()

// im confused since it seems like the function is being defined when
// var is put in front so how can a function be definied in a function
// the call back function is definied but is it not passed over?
// in previous code the call back function was called later
// in this case the callback function stops the flow of code until it's
// completed before the post request is sent
// how does java script worked

var sendToServer = function (note) { //declare func to send to server
  var xhttpForPost = new XMLHttpRequest() //Create object to send post req
  xhttpForPost.onreadystatechange = function () { //call back
    if (this.readyState == 4 && this.status == 201) {
      console.log(this.responseText) //when this is done print
    }
  }
  

  //creates a POST request
  xhttpForPost.open("POST", '/exampleapp/new_note_spa', true)
  //sets the content-type as application/json to tell server it's app/json?
  //is there a standard or prebuilt or is the server suppose to recognized
  //application/json as the content type and handle it? So not built in?
  xhttpForPost.setRequestHeader("Content-type", "application/json")
  //Send the stringifyied note with all the headers
  xhttpForPost.send(JSON.stringify(note));
}

window.onload = function (e) { //when the page is loaded
  var form = document.getElementById("notes_form") // get the element
  form.onsubmit = function (e) { //what is e?
    e.preventDefault() //prevent default

    var note = {
      content: e.target.elements[0].value,
      date: new Date()
    }

    notes.push(note)
    e.target.elements[0].value = ""
    redrawNotes()
    sendToServer(note)
  }
}

```