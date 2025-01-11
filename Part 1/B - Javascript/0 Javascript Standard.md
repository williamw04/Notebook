The official Javascript standard we're using is [ECMAScript](https://en.wikipedia.org/wiki/ECMAScript).At this moment, the latest version is the one released in June of 2023 with the name [ECMAScript®2023](https://www.ecma-international.org/ecma-262/), otherwise known as ES14.

Browsers do not yet support all of JavaScript's newest features. Due to this fact, a lot of code run in browsers has been _transpiled_ from a newer version of JavaScript to an older, more compatible version. ^ff3f88

Today, the most popular way to do transpiling is by using [Babel](https://babeljs.io/). Transpilation is automatically configured in React applications created with vite. We will take a closer look at the configuration of the transpilation in [part 7](https://fullstackopen.com/en/part7) of this course. ^710880

### Transpilation
Transpilation is the act of converting high level language to another form of high level language

This includes:
- Converting from one version of a programming language to a older or newer version
- Converting from one high level language to another such as type script

This is the opposite of compilation where high level language is compiled into a lower level form. Babel is the most popular way for javascript. This is important in the context of javascript since transpilation needs to occur to account for converting next-gen Javascript to a older/previous browser compatible Javascript version. [[#^ff3f88]] [[#^710880]]

### What is Node.js
Node.js is a **JavaScript runtime environment** that allows you to run JavaScript **outside of a web browser**.

- It is built on **Google’s Chrome V8 JavaScript engine** (the same engine used by Chrome to execute JavaScript).
- Node.js enables JavaScript to be used for **server-side programming** and can run on **any platform** (Windows, macOS, Linux, etc.).

### How does Node.js work
- **Compilation to Machine Code**: The V8 engine **compiles JavaScript into machine code**, making it fast and efficient.
- **Cross-Platform**: Node.js **works across different operating systems** by abstracting OS-specific functions through **platform-independent APIs**.
- **APIs**: On top of V8, Node.js provides APIs for tasks that JavaScript can't typically do in a browser, such as:
    - **File system operations (`fs`)** – Read, write, and manage files.
    - **Networking (`http`, `https`)** – Create servers, make HTTP requests.
    - **Streams** – Handle data streams (great for large files or real-time apps).
    - **Process management** – Control and manage processes at the OS level.

### **Key Features of Node.js**:
- **Event-Driven, Non-Blocking I/O**: Node.js uses an asynchronous, event-driven model, meaning:
    - It can handle **multiple requests concurrently** without waiting for previous tasks to complete.
    - This makes it highly efficient for **scalable network applications**.
- **Single-Threaded**: Node.js runs on a **single thread** but can handle many connections at once using **non-blocking I/O** and callbacks.
- **npm (Node Package Manager)**: Node.js comes with **npm**, the largest ecosystem of open-source libraries and packages, which makes development faster and easier.

### **Correcting a Few Points from Your Description**:

- **Node.js doesn’t run directly on mobile phones by itself.**
    - However, **mobile development tools** (like React Native) or **backend services for mobile apps** (like APIs) can be powered by Node.js.
- **Node.js doesn't run identically on mobile and servers**. While the core runtime is the same, the specific environment (file systems, OS-level APIs) may differ. However, JavaScript code is **mostly portable** between platforms.

### ### Refined Version of Your Understanding:

**Node.js is a JavaScript runtime environment built on Google's Chrome V8 engine that allows JavaScript to run outside of the browser, enabling server-side and backend development. It works across platforms (Windows, Linux, macOS) by compiling JavaScript into machine code using the V8 engine. Node.js extends JavaScript by providing APIs (`fs`, `http`, etc.) for server operations, networking, and file system interactions, which are not natively available in browsers. Its event-driven, non-blocking architecture makes it ideal for building scalable and high-performance applications.**


Takeaway:
The javascript runtime environment exists in the browser and on a server/mobile. They both build upon chrome's v8 javascript engine. The v8 engine drives the application and can offload tasks for example in the browser when the web api or call back function is invoked (creates an execution context) and then on the stack it is moved onto the browser for it to handle asynchronously (in the background). When it's finished it's moved into the Task queue where teh event loop will move the finished product back to the call stack in the engine when there's nothing in the stack.


Transpilation: is the act of converting code from a high abstraction to another high abstraction. The reason may be:
- One language to another
- The browser might not support the latest version of javascript.

