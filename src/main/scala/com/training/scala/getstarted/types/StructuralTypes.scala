package com.training.scala.getstarted.types

/**
 * Structural types can be used to define type bound on interface structure
 * i.e. one can define type bounds by confirming if a particular function or
 * variable is defined inside a argument being passed
 */

trait Printer {
  val defaultValue = 10

  def print = println(defaultValue)
}

case class IntNumber(num: Int) extends Printer  {
  def addOne = num + 1
}

case class FloatNumber(num: Float) extends Printer {
  def addOne = num + 1F
}

object StructuralTypes extends App {

  /**
   * This function accept argument `data` of type `A` such that
   * `A` contains a implementation of function named `addOne` which
   * takes in no args and returns `Int`
   *
   * Note: Multiple interface structures can be defined separated by semicolon
   * Eg:- `[A<: {def addOne: Int; def print}]`
   */
  def printFunctionResult[A <: {def addOne: Int}](data: A) = println(data.addOne)

  /**
   * This function accept argument `data` of type `A` such that
   * `A` contains a implementation of function named `print` which
   * takes in no args and returns `Unit`
   */
  def callPrintFunction[A <: {def print}](data: A) = data.print // you where able to call print b/c of structural type defined

  /**
   * This function accept argument `data` of type `A` such that
   * `A` is a subtype of `FloatNumber` and has an `val defaultValue: Int`
   * as its member variable
   */
  def printDefaultValue[A <: FloatNumber {val defaultValue: Int}](data: A) = println(data.defaultValue)

  printFunctionResult(IntNumber(2))  // Res: 3
  callPrintFunction(IntNumber(2))    // Res: 10
  callPrintFunction(FloatNumber(2F)) // Res: 10
  printDefaultValue(FloatNumber(2F)) // Res: 10
  /*
  printFunctionResult(FloatNumber(2F))   // Compile time error:
                                         // type mismatch: does not conform to method printFunctionResult's
                                         //                type parameter bounds [A <: AnyRef{def addOne: Int}]
                                         //
                                         // This is because `FloatNumber` does not contain a function `addOne` which returns `Int`

  printDefaultValue(IntNumber(2))        // Compile time error:
                                         // type mismatch: does not conform to method printDefaultValue's
                                         //                 type parameter bounds [A <: com.training.scala.getstarted.types.FloatNumber{val defaultValue: Int}]
                                         //
                                         // This is because there is additional check of concert type(FloatNumber) in `printDefaultValue`
                                         // definition
   */
}
