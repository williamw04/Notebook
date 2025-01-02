App.jsx defines a [[your first component]] named app. A react component represents a part of your site that is defined in javascript and be imported and reuse to structure your website.

In main.jsx this line renders its contents into the div elevent with the attribute ID='root' defined in index.html 
```js
ReactDOM.createRoot(document.getElementById('root')).render(<App />)
```

By default the html code doesn't contain an markup that is rendered on the page. Notice that there's a div that doesn't contain anything and script with the source file linked to /src/main.jsx
```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/svg+xml" href="/vite.svg" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Vite + React</title>
  </head>
  <body>
    <div id="root"></div>
    <script type="module" src="/src/main.jsx"></script>
  </body>
</html>
```

you could create html to be rendered but what's the point when you're using react just create a component/


#### Defining a component in javascript

```js
const App = () => (
  <div>
    <p>Hello world</p>
  </div>
)
```

this component has two parts the variable definition part const app and the function definition. 

```js
() => (
  <div>
    <p>Hello world</p>
  </div>
)
```

the function is defined using the short hand syntax ([arrow functions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions)) for defining functions.


