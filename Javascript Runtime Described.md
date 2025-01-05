Understanding the javascript runtime environment is critical in understanding the behavior of your program, allow you to better understand why your program might not be functioning properly. 
![[Screenshot 2025-01-05 at 2.36.19 AM.png]]

In this section, we will be diving into how in javascript the program manages the execution of the program while using a single Call Stack.


### Call Stack
To elaborate on the previous section javascript is single threaded. Taking a look into the javascript engine, it consist of a heap where memory allocation happens, and the call stack which represents the progress of the program each line being passed in and executed.

Below is scenarios describing how the call stack would operate.

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

### Basics of Call Stack
First console.log('One') is called which creates a new execution context onto the Call Stack and then is evaluated. So imagine a line is read and it creates a entry onto the Call Stack providing all the details and resources so it can be executed and then on the Call Stack if it's the on top off the stack it gets evaluated and in this case it prints One. And this is done for console.log('Two')

Notice in the previous two lines the an execution context is made and put into the stack and it's immediately executed and the program operates normally.

### Recursive Case
Now logThreeAndFour(); is called which creates an execution context, and put onto the stack. It's being evaluated invoking a function, but inside that function before it finishes running it bumps into another function and creates the execution context of logThree() invoking another function. 

However the previous isn't finished being evaluated and pause saved for later since it may not be completed running (more code left or just to not lose track since a function technically isn't finished running since all the code hasn't been executed. Gotta wait for the function invoked inside to finish and return) and the new context is put on top and started to be evaluated. 
#### Recursive Example
To save explanation ill show the progress of the Call Stack over the duration of the program's execution.

Current Line: console.log('One')
CallStack: console.log('One') 
Eval:  console.log('One') 
Output: One!

Current Line: console.log('Two')
CallStack: console.log('Two') 
Eval: console.log('Two') 
Output: Two!

Current Line: logThreeAndFour()
CallStack: logThreeAndFour()
Starts execution of logThreeAndFour()

Current Line: logThree()
CallStack:  logThree() <- logThreeAndFour()
Starts exe of logThree()

Current Line: console.log("Three!")
CallStack: console.log("Three!") <- logThree() <- logThreeAndFour()
Eval:  console.log('Three') 
Output: Three!

CallStack:logThree() <- logThreeAndFour()
Eval: logThree() finishes running remove off stack

Current Line: console.log("Four!") <-- comes back and starts to run all code inside func
CallStack: console.log("Four!") <- logThreeAndFour()
Eval: console.log("Four!")
Output: console.log("Four!")

Cur Stack:logThreeAndFour()
Eval: logThreeAndFour() finishes running remove off stack

Confusing yeah but this illustrates the downsides to single threaded  programs. Often if there's recursion the callstack grows exponentially but multi threaded programs can't really do much about that and that's just the downside to recursion. Can be reduced through memoization/cache but this is a separate discussion.

#### Large Computational Example
To come back on track here's another scenario

![[Screenshot 2025-01-05 at 3.03.05 AM.png]]
In this program longRunningTask is doing a computational straining task which takes a long time to be completed halting the progress of the rest of the program. This is known as a blocking.


### Web API's
In browser the runtime environment for