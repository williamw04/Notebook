In html files can contain a link to a css file. CSS (Cascade Styling Sheet) is a style sheet language and is a technology used to personalize and stylize your site. 

It does this by applying certain styles to selectors. A selector applies a set of rules/tells the browser how to style a singular or a group of nodes/elements in a html document that share the trait/attribute.  

"These are used to select certain parts of the page and to define styling rules to style them."

There are class selectors and id selectors. 

You can select elements in the inspect element tool and view the style applied to an element.

```css
.container {
  padding: 10px;
  border: 1px solid;
}

.notes {
  color: blue;
}
```

example: The CSS rule defines that elements with the _container_ class will be outlined with a one-pixel wide [border](https://developer.mozilla.org/en-US/docs/Web/CSS/border). It also sets 10-pixel [padding](https://developer.mozilla.org/en-US/docs/Web/CSS/padding) on the element. This adds some empty space between the element's content and the border.

The second CSS rule sets the text color of the _notes_ class as blue.

HTML elements can also have other attributes apart from classes. The _div_ element containing the notes has an [id](https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/id) attribute. JavaScript code uses the id to find the element.