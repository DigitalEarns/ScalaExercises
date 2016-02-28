package com.problems.partialfunctions

object PartialFunctionJob {

  // partial function to compute 30 / x, which is not defined for x = 0
  def fraction = new PartialFunction[Int, Int] {
    def apply(i: Int) = 30 / i
    def isDefinedAt(i: Int) = i != 0
  }

  // partial function to increment the integer elements by 1 in a list
  def incAny: PartialFunction[Any, Int] = { case i: Int => i + 1}

  def main (args: Array[String]): Unit = {
    val y = List(10, 20, 30, 0) collect fraction
    println("y = " + y)

    val x = List(1, "AAAA", 2) collect incAny
    println(" x = " + x)

    println(" checking if fraction is defined for 0 " + fraction.isDefinedAt(0))

    // following call should thorw an ArithmeticException
    val z = fraction(0)
    println ("z = " + z)

  }
}
