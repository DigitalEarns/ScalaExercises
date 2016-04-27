package com.training.scala.getstarted

/*
 * reduceLeft and reduceRight cumulate a single result.
 *
 * foldLeft and foldRight cumulate a single result using a start value.
 *
 * scanLeft and scanRight cumulate a collection of intermediate cumulative results using a start value
 *
 * Reference: http://stackoverflow.com/questions/17408880/reduce-fold-or-scan-left-right
 *
 */

object ScanReduceFold extends App {
  val abc = List("A", "B", "C")

  def add(res: String, x: String) = {
    println(s"op: $res + $x = ${res + x}")
    res + x
  }

  println("Reduce Left = " + abc.reduceLeft(add))
  // op: A + B = AB
  // op: AB + C = ABC    // accumulates value AB in *first* operator arg `res`
  // res: String = ABC

  println("Fold Left = " + abc.foldLeft("z")(add)) // with start value "z"
  // op: z + A = zA      // initial extra operation
  // op: zA + B = zAB
  // op: zAB + C = zABC
  // res: String = zABC

  println("scan Left = " + abc.scanLeft("z")(add))
  // op: z + A = zA      // same operations as foldLeft above...
  // op: zA + B = zAB
  // op: zAB + C = zABC
  // res: List[String] = List(z, zA, zAB, zABC) // maps intermediate results

}
