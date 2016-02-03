package com.training.scala.getstarted

/*
 *  Function currying.
 *
 *  a function for arguments x, y  defined as f(x, y) =  2*x*y + x+y
 *
 *  now, we are applying x = 2 , i.e apply the function 'f' partially.
 *
 *  noy f(2, y) = 2*2*y + 2 + y
 *              = 4*y + 2 + y
 *              = g(y)
 *  the result is nothing but another function `g` which has argument as `y`.
 *
 *  More formally,
 *
 *  currying is the technique of translating the evaluation of a function
 *  that takes multiple arguments  into evaluating a sequence of functions,
 *  each with a single argument.
 *
 */
object Currying {
  def main(args: Array[String]) {

    /* Please not that the function arguments are grouped to form multiple
     * parameter lists. So that they can be applied partially
     */
    def multiply(m: Int)(n: Int): Int = m * n

    println("Multiply 2 * 3 = " + multiply(2)(3))

    // apply in curried fashion, partially applied
    // result of partial application `timesTwo` is nothing but a function
    // that accepts an integer argument.
    val timesTwo = multiply(2) _
    println("times Two = " + timesTwo)

    //  `timesThree` is actual value.
    val timesThree = timesTwo(3)
    println("Final = " + timesThree)
  }
}
