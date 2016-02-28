package com.training.scala.getstarted

/*
 * An example to demonstrate the use of package objects
 */
object PackageObjExample {
  def main(args: Array[String]): Unit = {
    val getValue: String = commonVal
    println(s"A string val used from package object = ${getValue}")

    val d: Double = convertToDouble("10.0")
    println(s"Converted to Double = ${d}")
  }
}
