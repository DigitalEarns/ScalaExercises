package com.training.scala.getstarted

/**
 * Hello Scala - First exercise
 */
object HelloScala {

  def main (args: Array[String]): Unit = {

    println("Hello Scala")

    // initializing an immutable object/variable using val
    val a: Int = 10
    println(a)

    // Re assignment to a val?? uncomment and see the compilation error.
    // a = 20

    // initializing a mutable variable using var
    var b = 20
    b = 30

    //lazy - expression is executed only when there is reference to it
    lazy val x = 30
    val y = x + 50 // x is actually initialized while executing this line
  }
}
