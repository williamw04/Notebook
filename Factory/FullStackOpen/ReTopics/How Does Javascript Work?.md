## Preface:

Understanding the JavaScript runtime environment is essential for grasping how your program behaves and why certain issues may arise during execution. This knowledge allows you to diagnose and troubleshoot problems more effectively.

In this section, we will explore how JavaScript manages program execution using a single **Call Stack**. This stack-based execution model plays a key role in how JavaScript handles function calls, processes events, and manages asynchronous code.
![[Screenshot 2025-01-05 at 2.36.19 AM.png]]

Javascript code works by being ran in the browser environment and in the server environment. The environment is the way javascript code is processed compiled and ran. Examples of environments would be the browser and server environments which provide more functionality upon normal javascript. Some functionality provided may be server side operations or browser operations. Depending on where javascript runs i,e the server or the browser the javascript env differs providing different apis.  Across the environments is the core javascript engine and environments contains a call stack, and event loop, a callback queue, other apis etc....

### The Javascript Engine:
The javascript engine is what controls the flow and manages the programs. Think of it as the mastermind providing the requested dependencies, resources, completing and delegating task and determining the sequence in which your program will run. A widely used javascript engine is the chrome V8 javavscript engine. However the mentioned engine has all basic javascript features, and is only a component within the javascript environment and other provided components extends the functionality of javascript. The javascript engine only contains a callstack and a heap.

# The other parts

## The Call Stack

In the previous section, we mentioned that JavaScript is **single-threaded**. This means that JavaScript can only perform **one task at a time**. ^6729ab

The JavaScript engine (such as **Chrome's V8** engine) forms the core of the **runtime environment**. The engine consists of two key components:

1. **Heap** – where memory allocation happens.
2. **Call Stack** – which tracks the execution of code by keeping a record of function calls. Each line of code that is executed enters the call stack, allowing the program to track and manage progress.

Below is an example demonstrating how the call stack operates:

```js
console.log('One')
console.log('Two')

function logThree(){
	console.log('Three!');
}

function logThreeAndFour(){
	logThree();
	console.log("Four!");
}

logThreeAndFour();
```

### Basics of the Call Stack

- **One thread = One call stack = One task at a time.**
- JavaScript executes code sequentially, line by line, following the **Last In, First Out (LIFO)** principle.

Here’s how the call stack operates for the code above:

1. `console.log('One')` is called. This creates a new **execution context** that is pushed onto the call stack. Once executed, it is popped off the stack, and "One" is printed.
    
2. `console.log('Two')` follows the same process: it is pushed, executed, and popped off the stack. "Two" is printed.
    
3. `logThreeAndFour()` is invoked, creating a new execution context and pushing it to the call stack.
    
4. Inside `logThreeAndFour()`, `logThree()` is called. This pushes **another execution context** onto the stack for `logThree()`. "Three!" is printed, and its context is removed.
    
5. After `logThree()` completes, `console.log('Four!')` is executed within `logThreeAndFour()`. "Four!" is printed, and the call stack is cleared once the function finishes.

### Recursive Case
Now logThreeAndFour(); is called which creates an execution context, and put onto the stack. It's being evaluated invoking a function, but inside that function before it finishes running it bumps into another function and creates the execution context of logThree() invoking another function. 

However the previous isn't finished being evaluated and pause saved for later since it may not be completed running (more code left or just to not lose track since a function technically isn't finished running since all the code hasn't been executed. Gotta wait for the function invoked inside to finish and return) and the new context is put on top and started to be evaluated. 
### Recursive Example – Call Stack Progression

To illustrate how the JavaScript call stack operates during program execution, let's break down the process step by step:

### Call Stack Walkthrough:

**1. Current Line:** `console.log('One')`

- **Call Stack:** `console.log('One')`
- **Evaluation:** Execute `console.log('One')`
- **Output:** `One!`
- **Result:** Call stack is empty after `console.log` finishes.

---

**2. Current Line:** `console.log('Two')`

- **Call Stack:** `console.log('Two')`
- **Evaluation:** Execute `console.log('Two')`
- **Output:** `Two!`
- **Result:** Call stack is empty again.

---

**3. Current Line:** `logThreeAndFour()`

- **Call Stack:** `logThreeAndFour()` (New execution context is created)
- **Starts Execution:** The function `logThreeAndFour` begins executing.

---

**4. Current Line (Inside `logThreeAndFour()`)**: `logThree()`

- **Call Stack:** `logThree() ← logThreeAndFour()`
- **Starts Execution:** `logThree()` begins execution.

---

**5. Current Line (Inside `logThree()`)**: `console.log('Three!')`

- **Call Stack:** `console.log('Three!') ← logThree() ← logThreeAndFour()`
- **Evaluation:** Execute `console.log('Three!')`
- **Output:** `Three!`

---

**6. After `logThree()` Finishes:**

- **Call Stack:** `logThree() ← logThreeAndFour()`
- **Evaluation:** `logThree()` finishes. Remove it from the stack.

---

**7. Current Line (Back to `logThreeAndFour()`)**: `console.log('Four!')`

- **Call Stack:** `console.log('Four!') ← logThreeAndFour()`
- **Evaluation:** Execute `console.log('Four!')`
- **Output:** `Four!`

---

**8. After `logThreeAndFour()` Finishes:**

- **Call Stack:** `logThreeAndFour()`
- **Evaluation:** `logThreeAndFour()` finishes. Remove it from the stack.

---

**Final State:**

- **Call Stack:** Empty

---

#### Key Clarifications:

- The execution context is **pushed onto the stack** when a function is invoked and **popped off** when the function returns.
- The function that is currently running will always be at the **top** of the stack.
- Once the stack is empty, JavaScript is idle until the next task (such as an event or timeout) enters the queue.

---

#### Recursion is slow:
- **Memoization** and **caching** can optimize recursion by avoiding redundant calculations.
- Techniques like **tail call optimization** (in some environments) can prevent the call stack from growing during recursion.

#### Large Computational Example
To come back on track here's another scenario

![[Screenshot 2025-01-05 at 3.03.05 AM.png]]
In this program longRunningTask is doing a computational straining task which takes a long time to be completed halting the progress of the rest of the program. This is known as a blocking which is slow behavior so the application is slow due to design

In deep recursion it is important to note that a risk of a stack overflow. The stack is not limitless and has a memory capacity.

#### The Solution:
Asynchronous tasks. Having tasks that are offloaded from the stack that can be done in the background or that might hold up the application. We don't want the single thread that is handling the application runtime to be held up.

## Asynchronous callbacks and Web API's
Due to the design of javascript [[#^6729ab]] most of the functions are non blocking since if they were they would halt site due to the single threaded nature (handling one task at a time). Imagine if a site was handling a network request and this was was blocking function. This would stop the rest of the site from functioning like clicking other buttons. This means  we run the code get a callback and run it later.

### Async Callbacks & The Call Stack

```js
console.log('hi') // execution context is created on the stack, ran and popped
setTimeout(function() { // exec context created on the stack and disappears 
	console.log('there');
},5000);
console.log('JSConfEU'); // 2nd print statement but what happened to the other console statement?
```

So what happens is that the async function is offloaded somewhere else to be complete in the background while the javascript engine continues running the program and processing the stack.

Where does it go?
### Concurrency & The event loop
There's a different component asides from the javascript runtime (whatever that )

If you clones the javascript engine, chrome v8, and tried to grep and look for the DOM or server communication it's not in there. This is because ontop of the Javascript engine is provided an api by the browser that the javascript engine can communicate with. This api and other components (which we will get too) has different and exclusive access to some other allocated threads and memory

