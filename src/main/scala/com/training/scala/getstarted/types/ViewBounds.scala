package com.training.scala.getstarted.types

/**
 * View bounds `<%` can be in cases where a argument variable passed in can
 * be view as another or more precisely to be able to pass in arg types that
 * are implicitly converted to the required type
 *
 * View Bounds is `deprecated` from Scala 2.8.0, please refrain from using them
 * just kept here as an example
 *
 * References:
 * https://github.com/scala/scala/pull/2909
 * http://stackoverflow.com/questions/4465948/what-are-scala-context-and-view-bounds
 */

object Calculator {

  /**
   * In this function, `[A <% Int]` means `A` can take in any type that
   * has a implicit conversion defined that converts it to type `Int`
   */
  def sum[A <% Int](var1: A, var2: Int) = var1 + var2
}


object ViewBounds extends App {
  /**
   * A implicit definition that converts all `String` defined inside
   * this object to `Int`
   */
  implicit def strToInt(x: String) = x.toInt

  println(Calculator.sum("1", 2))  // Res: 3

  /*
  println(Calculator.sum(1.3, 2)) // Will result in compile time error:
                                  // No implicit view available from Double => Int
                                  //
                                  // To make this work will have to write a implicit
                                  // conversion that does the conversion
  */
}
