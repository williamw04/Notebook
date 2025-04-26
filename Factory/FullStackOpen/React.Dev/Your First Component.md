HTML allows us to use tags to describe our page, css allows us to stylize these pages and javascript gives it functionality. Here's an example of a html component

```html
<article>  
	<h1>My First Component</h1>  
	<ol>  
		<li>Components: UI Building Blocks</li>  
		<li>Defining a Component</li>  
		<li>Using a Component</li>  
	</ol>  
</article>
```

React allows you to combine html, css and javascript and create components which are reusable pieces of your websites. For example imagine you've created a navigation bar. With html,css and javascript you would have to create it for every page, but with React you create once and you can use it in all pages. That's the power of react components.

Takeways:
-This comes from the necessity to lessen amount of code
-This is like classes or like functions already defined you don't have to redefine them because it's pain usually.
-Away from traditional websites
-Feels like this will lead to SPA, so the server will request html and in browser logic will manipulate it

### How does React Syntax look like?
React comprises of tags just like html, you can order and nest components to design whole pages. 

```
<PageLayout>
	<NavigationHeader>  
		<SearchBar />  
		<Link to="/docs">Docs</Link>  
	</NavigationHeader>  
	<Sidebar />  
	<PageContent>  
		<TableOfContents />  
		<DocumentationText />  
	</PageContent>  
</PageLayout>
```

### Benefits of using React
As your project grows, you may notice parts of your website are the same and you're rewriting it such that a nav bar a heading maybe a search bar. All these parts can be created into the component and you could reuse the component to speed up your development. 

There are also thousands of precreated componenets shared withi the React Open Source Community such as Chakra UI and Material UI.

### Defining a component
React component is a [[JavaScript Function]] that you can sprinkle with markup.

```js
export default function Profile() {
  return (
    <img
      src="https://i.imgur.com/MK3eW3Am.jpg"
      alt="Katherine Johnson"
    />
  )
}
```

