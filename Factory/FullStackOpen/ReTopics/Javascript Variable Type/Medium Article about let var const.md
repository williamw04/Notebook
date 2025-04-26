```js
for(var i = 0; i<10;i++) {
  console.log(i)
}
console.log(i)
```

### Var

Notice the behavior of the var i in this case. The output would be proper eventhough var i was declared within the for loop. In other programming languages the variable i would not be defined outside the scope of the for loop.
- `var` is **function-scoped** or **globally scoped** if declared outside any function.
- The `for` loop does **not create a new scope**.
- - As a result, `i` is still accessible **outside the loop**.

takeaway: The scope of var variables are inside the entire function definition. A for loop is not a function and variables are only function scoped meaning that the scope of i does not exists only within the for loop.
- Variables declared with `var` inside a block (like a `for` loop or `if` block) are not limited to that block.
- This is different from many other languages, where loop variables are block-scoped.


```js
let test = function(){
  for(var i = 0; i<10;i++) {
    console.log(i)
  }
  console.log(i)
}

test()
  console.log(i)

```

**Explanation**:
- `i` is scoped to the `test` function, but not globally.
- When `test()` is called, `i` is accessible **within the function**.
- However, `i` **does not exist outside** the function.
- The `ReferenceError` happens **after all previous output** has been printed.

In this case we are declaring a function and setting it equal to test. In this scenario running it would first print out the function's output that was stored to test, but the last console.log outside the function prints an error.

**Takeaway**:
- **`var` is function-scoped**. If `var` is declared inside a function, it can't be accessed outside of that function.
- Errors don't stop execution until JavaScript hits the actual line that causes the error.

The last console.log tries to print out i which in the scope not defined. Furthermore javascript will print out all the outputs up until an error. 

### **Output Buffering in JavaScript**:
**Does JavaScript use output buffering like C, or does it print immediately?**
- In **C**, `stdout` often uses **line buffering**, meaning output is stored in a buffer and flushed to the console **only when a newline (`\n`)** appears or `fflush()` is called.
- In **JavaScript** (in browsers and Node.js), `console.log()` **immediately sends the output to the console**.
- There is **no manual flushing needed** – JavaScript outputs as soon as `console.log()` is called.

### Why is There No Buffering in JavaScript?

- **JavaScript is designed to be asynchronous and non-blocking**, unlike C.
- **Node.js** and browsers prioritize **immediate output** to ensure **real-time feedback** for debugging.

example:
```js
console.log("Hello"); setTimeout(() => console.log("World"), 1000); console.log("Done");
```

```
Hello 
Done 
World (1 second later)
```


### **Exception – Asynchronous Operations**:

- In asynchronous tasks (like file reads in Node.js), you might experience **delays** between operations, but that's not due to buffering – it's just asynchronous execution.

```node.js
const fs = require('fs'); fs.readFile('file.txt', 'utf8', (err, data) => { console.log(data); }); console.log('Reading...');
```

```
Reading...
(file contents appear later)

```

so in this case there is no delay but due to the nature of async functions such that it sees the function executes it in the background and moves onto the next line.

### Let
The issue of function scope variables leads to the addition of let dec. Let variables are bracket bound {} meaning it's bounded within for loops.

### Const
Const variables are meant to define variables one time and you cannot redefine them. This doesn't not mean you cannot change the properties of objects since that's not reassigning the const variable.
### Last Example
```js
var i
i = 34
for(let i =0; i<4; i++){
 console.log(i)
}
console.log(i)
```

console:
- 0
- 1
- 2
- 3
- 34