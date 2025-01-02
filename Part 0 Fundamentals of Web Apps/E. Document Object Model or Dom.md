HTML Pages structures in tree structures
```
html
  head
    link
    script
  body
    div
      h1
      div
        ul
          li
          li
          li
      form
        input
        input
```
elements have children outermost left inner most right.

The tree structure is the design of page being displayed. Document Object Model (DOM) is an api that enables modifying the elements through code (not manual). The javascript code in the previous chapter [[D. Event handlers and Callback functions]] used the DOM-API to add a list of notes to the page. 

The code below is a snippet from the javascript code:

```js
var ul = document.createElement('ul')

data.forEach(function(note) {
  var li = document.createElement('li')

  ul.appendChild(li)
  li.appendChild(document.createTextNode(note.content))
})
```
creates a new element u1 and adds the child elements/nodes li to it. The final tree branch of the u1 variable is connected to its proper place in the html of the whole page:
```js
document.getElementById('notes').appendChild(ul)
```
Dynamically altering the structure/generating html by manipulating the document structure using the getElementById to retrieve the element/node since id are unique and appending it puts it in the correct place.