package com.training.scala.getstarted

/**
 *  One simple example of sealed trait and its usage.
 *
 *  Sealed traits can be considered as alternative to `Enums` (But not limited to) .
 *  The constraint of sealed trait is that they can be only extended single file
 *  where the trait itself is defined. By this constraint compiler knows every possible
 *  subtypes and can reason about it.
 */

sealed trait SuperType

case class ASubType(a: Int) extends SuperType
case class BSubType(b: String) extends SuperType

// This is a companion object as well
object SuperType {

  def doSomethingWith(st: SuperType): Unit = {

    println("inside doSomething")
    st match {
      case ASubType(_) => println ("do A")

      // Comment the following match for BSubType and see the warning. Sealed Trait helps the compiler to do an
      // exhaustive check of its type and usage
      case BSubType(_) => println ("do B")
    }
  }
}

// Driver program
object RunApp {
  def main(args: Array[String]) {
    SuperType.doSomethingWith(ASubType(10))
  }
}