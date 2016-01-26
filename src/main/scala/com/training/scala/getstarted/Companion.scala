package com.training.scala.getstarted

/**
 *  Example of Companion object and its usage
 */

// Companion Class
class Companion(argString: String) {
  private var extraData = ""
  override def toString = argString + extraData
}

// object name is same as the class name. (Companion Object)
object Companion {
  def apply(base: String, extra: String): Companion = {
    val s = new Companion(base)
    s.extraData = extra
    s
  }

  // Usage of apply method. It is useful when you have a common operation to be done whenever you create
  // an object
  def apply(base: String) = new Companion(base)
}

object RunJob {
  def main(args: Array[String]) {
    println(Companion("Hello", "Scala"))
    println(Companion("Hello"))
  }
}
