#### Static Websites
For traditional web applications, the browser fetches the HTML document detailing the structure and textual content of the page and then renders this document into a webpage somehow. The html document is some static text file stored in some directory in a server. 

Servers can also form HTML document dynamically according to some application's code an example which can be using some data from a database to form this web page. In the examine application, html code was formed dynamically because it contains information on the number of created notes.

The html code below was formed dynamically

``` html
const getFrontPageHtml = noteCount => {
  return `
    <!DOCTYPE html>
    <html>
      <head>
      </head>
      <body>
        <div class='container'>
          <h1>Full stack example app</h1>
          <p>number of notes created ${noteCount}</p>
          <a href='/notes'>notes</a>
          <img src='kuva.png' width='200' />
        </div>
      </body>
    </html>
`
}

app.get('/', (req, res) => {
  const page = getFrontPageHtml(notes.length)
  res.send(page)
})
```

The content of the html page was saveed as a template string that allows for evaluation for example variables like noteCount. The dynamic part of the html is the number of saved notes (in the code noteCount) is replaced by the current number of notes (in the code notes.length) in the templates tring

You could have variables in a html "Template" so all the other code is staticed and ready to be rendered but the variables will be replaced dynamically.

#### Traditional Web Browsers
Traditionally web browsers are dumb they request a webpage from a server and renders it, the server then processes requests ,fetches data from a database and even generates the html for it. Javscript would be used to make the site interactive but didn't handle core application logic.

#### Modern web apps (client-side rendering) 
Browser sent html page and a javscript file. The javascript file then runs in the browser and dynamically fetches data from the server via apis. Pages can also dynamically update meaning it doesn't have to reload and alot of the application logic(fetching and updating data) can happen in the browser. (Image the server is the kitcen and the they bring ingredients to you where you can then make your own food)

In conclusion, traditional web apps, the browser doesn't make decsisions or handle any of complex logic it lets the server handle that and the job is the just display the result. Modern apps take a more active role fetching updating data and dynamically rendering and updating the page within the app.

#### Upsides to client-side app (browser handles most of the logic)
Client & Responsiveness
- The page doesn't reload when you click something
- Only new data istead of the whole page is requested
- The browser can instantly update the ui without communicating with the server.
Reduced Server Load:
- Less processing such as not having to load full html pages or handle application tasks i.e server send raw dad (JSON)
- Since most of the work is done by browsers (the clients) there's less of a stress on servers meaning allowing to handle more users with a less massive infrastructure.
Better User Experience (UX):
- Updates are quicker so it feels more interactive and dynamic
- Offline functionality: browsers store information in house instead of using a server so once back online the server can sick with the browser data (done used indexDB and localStorage)

#### Downsides to client side apps
- Exposing sensitive Data: If sensitive logic runs in the browser (like password checks) this can be reversed engineered by attackers
	- Mitigation: Sensitive operations still happen on the server (payments, user auth)
	- Browser mainly handles display logic and data fetching
	- Use API's to fetch and update. 
- Attackers can intercept and modify API calls ( changing prices in a shopping cart)
	- Mititgation: use server-side validation so the server double-checks.
- Cross-Site(XSS): if a website allows unfiltered Javascript attackers can inject malicous code
	- Mitigation: Santize all user inputs *What is santize* and use Content Security Policy (CSP) to block unauthroized scripts (interesting somehow stop users from running scripts by using some certificate or authen system for scripts)
-  Storing authentication tokens (Such as JWTs) inbrowser can be risky. Prolly cus they can be accessed and manipulated etc...
	- Mitigation: Use HttpOnly cookies (no accessible by Javascript) for storing sensitive tokens.

