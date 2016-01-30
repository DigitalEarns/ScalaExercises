package com.training.scala.getstarted

/**
 *  Example of Companion object and its usage
 */

// Companion Class
class MyClass(argString: String) {
  private var extraData = ""
  override def toString = argString + extraData
}

/*
 * Companion Object: object name is same as the class name.
 *
 * Please note that the Companion object must be defined in same `.scala`
 * source file as of the Companion Class.
 *
 * The common use case for companion object is to define singleton methods
 * and values. Its roughly equivalent to static methods and members in Java.
 *
 */
object MyClass {
  /* The `apply` method in Scala Companion objects are used for syntactic sugar
   * The following invocation will demonstrate this
   * */
  def apply(base: String, extra: String): MyClass = {
    val s = new MyClass(base)
    s.extraData = extra
    s
  }

  // overloaded `apply` method
  def apply(base: Int) = new MyClass(base.toString)
}

object RunJob {
  def main(args: Array[String]) {

    // Invoking the `apply` methods of Companion object.
    println(MyClass.apply("Hello", "Scala"))
    println(MyClass.apply(111))

    // Scala provides a Syntatic sugar, which makes the
    // following statements perfectly legal and gives the same result
    // as above

    println(MyClass("Hello", "Scala")) // The `apply` methods are not called explicitly,
    println(MyClass(111))              // Invocations looks like these factory methods are
  }
}
