### An exercise to learn higher order functions

Scala allows the definition of higher-order functions. These are functions that take other functions as parameters, or 
whose result is a function

Ex: apply is a function which takes another function f as an argument. It also takes value v, and apply f to v

  `def apply(f: Int => String, v: Int) = f(v)`

Question

   - write a function to check if a number passed into it is an even, function definition should be
        f: Int => Boolean
   - write a functiont o check if a number passed into it is on odd, function definition should be
        f: Int => Boolean
   - Create a List of any 10 numbers, and pass on the function to the list to filter the odd and even numbers and print
   
   - write a function which returns another function, as per the following conditions
        - if the number coming to the function is integer, return a function which will double the value
        - if the number coming to the function is odd, return a function to add 1 to it.
   