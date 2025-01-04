![[Pasted image 20241231220925.png]]
The browser does a get request to get the html code defining the structure of the page and its content by making a http get request to a server.

The browser receives the html document and it then scans for links. 

Sees a link and knows it needs a css file and a src file so it also needs a javascript file and does a Get request for both asynchronously

The javascript file makes a get request to the server for data.json
Server sends back info and then triggers a call back function that confirms the readState is equal to 4 meaning the state has changed and the operation is complete  and that the request was successful and completed.

Parses its contents and finds the div creates a new element to contain all the bullet points and then creates all the bullet points adding it to the bullet point container.