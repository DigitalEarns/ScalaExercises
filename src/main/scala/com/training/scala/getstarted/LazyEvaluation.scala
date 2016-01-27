package com.training.scala.getstarted

/**
 * Lazy Evaluation in Scala
 */
object LazyEvaluation {

  def main (args: Array[String]): Unit = {

    //lazy - expression is executed only when there is reference to it
    lazy val x = {
      println(" Computing the value of `x` ...")
      10 + 20 // last statement in a block is the return statement
              // i.e this block will return the computed value `30`
    }

    println("\n The value of x is not yet computed")

    println("\n Going to use `x` for the first time")
    val y = x + 50 // x is actually initialized while executing this line


    println("\n Going to use `x` for the second time")
    val z = x + 60

    println(s"\n y = $y \n z = $z")

    // Observe the the value of `x` is computed exactly once, when its used for the
    // first time.
  }
}
