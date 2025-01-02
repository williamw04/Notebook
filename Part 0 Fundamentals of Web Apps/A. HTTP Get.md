Servers and web browsers can communicate with each other using the http protocol.
#### What is HTTP (HyperText Transfer protocol)
HTTP is the foundation of internet communciations.

[[Key Concepts of HTTP]]:
Server-Client Relationship
- The client sends request to a server
- The server send response back to a client

Stateless:
- No extra information aside what's sent in a message is required.
- Each Request is independent. Doesn't remember previous request.

Response and Request:
- A client sends a request("I need information on the employee with this id)
- A sever sends a response("here the information on that employee)

#### [[Viewing HTTP and Http headers]]
The network tab shows how browsers and servers communicates.

Http headers are meta data regarding the communication between client server. The purpose of the headers is to provide context about request and response i.e allowing to customize the behavior of a request or to inform the server about the client. Humans can read it to understand  on what's really happening. 

The General Headers tell us the address the browser requested, the type of request method (get post etc.) and if the request was sucessful or not ( a sucessful response has status code 200 and not would be like 400 or something)

The Response Headers tells us the size of the response in bytes and the time of the reponse. An important header, Content-type, tells us the response was in a text file in utf-8 format and content of which have been formatted with html. This helps the browser distinguishes the contents should be treated as a regular HTML page and to then render the contents to the browser like a webpage. The response tab shows the response data, which unsuprisingly is the HTML code representing the page. 

#### [[#html]]

HTML (Hyper Text Markup Language) is a standard language used to create and design the structure of web pages. It's a foundational framework for websites, defining elements such as headings paragraphs, links images and other content

#### Key Characteristics of HTML:
- It is a markup language not a programming languge
- It uses tages to define elements and structure content
- HyperText: Has the ability to link other text or other elements to other documents which enables linking and navigating from webpage to webpage
- Cross-Platform: the platform doesn't matter and it can be used on any device with any web browser.
- Static Content: By itself it's used to create static webpages. HTML creates the barebone and you can style it and creating interactive pages using additional technologies (CSS For styling or JavaScript).

The requested html file 'exampleapp/' shows a regular html page. Within the html tag contains a head and body tag. FOCUSING on the body tab contains a div tag with the class attribute container. This doesn't make it a container directly but it labels it;s job and it does contain other elements. In order containing a header a paragraph a  hypertext that links to /exampleapp/notes and an image. The browser sees that the hmtl contains a image and to fulfill the image it needs to make a request to a server to get it. Bsically reading html to render website has everything until it gets to image. Sees an image tag and knows it can't render it cus it doesn't have the image so it needs to get it from a server.

 