call back functions is a function passed into another function as an argument. The inner function is invoked inside the outer function to complete some kind of routine or action.

An Example:
The user/consumer/client of a call-back based API creates a function and passes it into the API. The provider of the API (Caller) takes the function and calls back (executes the function)the function at some point inside the caller's body. The caller is responsible for passing the right parameters into the function or running the function at an approiate time. The caller function executes the call back function when the conditions are right when state changes.

There are two ways in which callback may be called :synchronous or asynchronous. Synchronous callbacks are called immediately after the invocation of the outer function with no intervening asynchronous tasks, while asynchronous callbacks are called a some later point after an asynchronous operation has completed.


Synchronous vs Asynchronous Callbacks:
Synchornous: Call back is executed immediately during the execution of the outer function. without delay or asynchronous tasks.
Asynchronous: Callback is executed laterm typically after an asynchronous operation (fetching data waiting for a timer)


#### Event Handlers
Event handler functions are functions that response to a certain event at a later time. These are a type of Callback Functions.