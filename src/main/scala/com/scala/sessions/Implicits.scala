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
    implicit def convertToInt(x: Double) = x.toInt
    val n: Int = 3.5

    
  }
}
