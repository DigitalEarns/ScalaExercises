package com.shapeless.examples

import shapeless._

import poly._

// choose is a function from Sets to Options with no type specific cases
// If given a Set as input, it returns the first( -- head -- ) element and as an Option type
// Reference : https://github.com/milessabin/shapeless/wiki/Feature-overview:-shapeless-2.0.0#polymorphic-function-values
object choose extends (Set ~> Option) {
  def apply[T](s : Set[T]) = s.headOption
}

object PolyMorphicFunctions {
  def main(args: Array[String]) {

    // no need of type specific classes. It is given out of the box from shapeless library

    // a Set of integer values
    val res1 = choose(Set(1, 2, 3))
    println("res1 = " + res1)

    // a Set of characters
    val res2 = choose(Set('a', 'b', 'c'))
    println("res2 = " + res2)
  }
}
