#### Running application logic in the browser

Within an html file has a head section which contains a script tag causing the browser to fetch a Javascript file e.g main.js

```javascript
var xhttp = new XMLHttpRequest()

xhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
    const data = JSON.parse(this.responseText)
    console.log(data)

    var ul = document.createElement('ul')
    ul.setAttribute('class', 'notes')

    data.forEach(function(note) {
      var li = document.createElement('li')

      ul.appendChild(li)
      li.appendChild(document.createTextNode(note.content))
    })

    document.getElementById('notes').appendChild(ul)
  }
}

xhttp.open('GET', '/data.json', true)
xhttp.send()
```

One the browser gets the script it immediately begins to execute the code. 

It declares and initalizes an xhttp object and declared a function that's ready to execute once the website state changes. The last two lines instructs the browser to do a HTTP GET request to the server's address /data.json

The request gets a json file off all the notes. The contents of which is then saved to
```javascript
this.reponseText
```
This changes the state of the website prompting the website to call the event handlers function.
Hold on...the order in code seems off. Taking a look into the structure the function defined to handle the response was found after the code that sends a request. The code further up is an  event handler for the event onreadystatechange which is defined for the xhttp object that's also executing the request. 

When the state of the object changes, state defined as the current configuration or the exact properties or conditions of the object so in a moment of time WHAT IT IS, IS LITERALLY ITS STATE.

Due to the request and fetching the information the state of the xhttp object changes and so then calls the event handler function. The function then checks the readState is equal to 4 (Depicits the situation. The operation is complete) and that the http status of the code response is 200.

```javascript
xhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
    // code that takes care of the server response
  }
}
```

This mechanism of invoking event handlers is commonly utilized in Javascript to deal with changes in state/when something happens such as when a website receives data a function that might use that data can finally be invoked having everything it needs to run. Event handler functions are also known as [[ReTopics/Callback Functions|callback functions]]
. 

Note  the application code does not invoke the function itself, but the browser (the runtime environment) handles ivoking the function at an appropriate time when the event has occurred.