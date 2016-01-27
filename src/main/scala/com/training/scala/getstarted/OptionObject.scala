package com.training.scala.getstarted

/**
 * An exmaple on the usage of Options
 */

object OptionObject {
  def main(args: Array[String]) {
    // a simple example, Map returns Option[T] for its get method
    val capitals = Map(
      "France"    -> "Paris",
      "India"     -> "Delhi",
      "Australia" -> "Canberra",
      "Japan"     -> "Tokyo"
    )

    // see the output to see the values being returned
    println(capitals.get("France"))
    println(capitals.get("Argentina"))

    toInt("10") match {
      case Some(x) => println(s"Successfully converted to $x")
      case None    => println("Can not be converted")
    }

    toInt("ABCD") match {
      case Some(x) => println(s"Successfully converted to $x")
      case None    => println("Can not be converted")
    }
  }

  // function to convert a given string to Int
  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: NumberFormatException => None
    }
  }
}
