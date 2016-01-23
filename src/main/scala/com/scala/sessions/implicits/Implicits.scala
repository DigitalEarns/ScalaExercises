package com.scala.sessions

object Implicits {

  implicit val message = "Thanks, Digital Earns"

  def printGreetings(greetings: String)(implicit endingText: String) = {
    println(s"${greetings} ${endingText}")
  }

  def main(args: Array[String]): Unit = {

    /*
     * Implicit Parameters example
     */
    // call the printGreetings method with an explicit parameter
    printGreetings("This is explicit") ("Thanks, Explicit")

    // Usage of an implicit parameter
    printGreetings("This is implicit")

    /*
     * Implicit Conversion example
     */

    // comment the function and you can see a compilation error for the assignment in the next line.
    // you may notice that we are not calling the function anywhere explicitly.
    implicit def convertDoubleToInt(x: Double) = x.toInt
    val n: Int = 3.5

    // more examples on implicit conversions
    implicit def convertStringToInt(x: String) = x.toInt
    val sum: Int = "123" + 1
  }
}
