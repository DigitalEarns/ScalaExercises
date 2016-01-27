package com.training.scala.getstarted

/**
 * Example of Higher Order functions and anonymous functions
 */
object HOFunction {

  /*
   * Functions are first class citizens in scala. i.e Just like we pass around
   * data objects in an OOP language , we can pass around functions in Scala.
   * Its very common in FP languages like Scala to have functions that takes
   * other functions as arguments or even return a function as result.
    * These type of functions are called as Higher Order Functions.
   */

  def main(args: Array[String]): Unit = {

    /*
     * Two things to note.
     *
     * 1.`myHigherOrderFunction` functions is defined within the scope  of the
     *   outer function `main`. Its not accessible outside the main method.
     *
     * 2.`myHigherOrderFunction` function takes two parameters one is a function
     *    and other one is a value. As usual in a statically typed Language
     *    we have specified the type of functions parameter. The first param `argFn`
     *    is function that accepts an integer and returns an integer(denoted by Int => Int),
     *    where as the second argument namely  `argVal` is simply an integer.
     */
    def myHigherOrderFunction(argFn: Int => Int, argVal: Int): Int = {
      println(" Inside myHigherOrderFunction ...... ")

      println(s"\n Applying the arg function to argVal = $argVal")
      argFn(argVal) // compute the argFn and return the result
    }

    /* a simple functions that accepts an integer and adds one to it and returns result
     * which is of type integer itself.
     * i.e. type of the function `addOne` is Int => Int
     */
    def addOne(arg: Int): Int = { arg + 1 }

    // invoking a higher order function
    val res = myHigherOrderFunction(addOne, 12)

    println(s"The result is $res")

    // Here our function `addOne` is too simple and is used exactly once
    // We can simplify the code using the following

    val res2 = myHigherOrderFunction((a: Int) => { a + 1 }, 12)

    // Here what we have done is , we have used an anonymous function,
    // A function without name. Its similar to the concept of anonymous
    // class in Java, where we declare a class without name.
  }
}


