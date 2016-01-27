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
    var b = 20 // a legal expression even though we haven't explicitly stated the data type of `b`.
               // Scala compiler can infer the data type as Int.
    b = 30     // we can mutate the value of `b` since its declared as `var`
  }
}
