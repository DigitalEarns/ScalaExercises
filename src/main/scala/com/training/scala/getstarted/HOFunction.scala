package com.training.scala.getstarted

/**
 * Example of Higher Order functions and anonymous functions
 */
object HOFunction {

  def main (args: Array[String]): Unit = {

    val a = 10

    // ex: calling anonymous function
    val a2 = doubleAnony(a)
    println("a2 = " + a2)

    // ex: higher order function, takes a function as argument (first argument)
    def doubleAVal(f:Int => Int, v: Int): Int = f(v)
    val b = doubleAVal(double, a)

    println("b = " + b)
    println(mul(10,20))
  }

  // normal function
  def double(x: Int): Int = x * 2

  // anonymous function definitions
  def doubleAnony = (x: Int) => x * 2
  def mul = (x: Int, y: Int) => x * y
}
