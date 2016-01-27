package com.training.scala.getstarted

/*
 *  Simple example on the usage of Currying on functons
 */
object Currying {
  def main(args: Array[String]) {

  println("Multiply 2 * 3 = " + multiply(2)(3))

  // apply in curried fashion, partially applied
  val timesTwo = multiply(2) _
  println("times Two = " + timesTwo)

  val timesThree = timesTwo(3)
  println("Final = " + timesThree)
  }

  def multiply(m: Int)(n: Int): Int = m * n
}
