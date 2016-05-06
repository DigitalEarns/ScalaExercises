package com.training.scala.getstarted.types

/**
  * Context Bound defines that a implicit value should be available in scope to call a function.
  *
  * Eg:
  *   `def fun[A : B](a: A) = a.get()`
  * for `fun` a implicit value of type B[A] should be available in the functions scope
  *
  * The above function can also be written as
  *   `def fun[A](a: A)(implicit value: B[A]) = a.get()`
  */

object AdderImplicits {
  trait Adder[T] {
    def add(value1: T, value2: T): T
  }

  implicit object IntAdder extends Adder[Int] {
    def add(value1: Int, value2: Int) = value1 + value2
  }

  implicit object StringAdder extends Adder[String] {
    def add(value1: String, value2: String) = value1 + value2
  }
}

object ContextBounds extends App {
  import AdderImplicits._ // To bring the implicits in scope

  /**
    * This method expects a implicit value of type `Adder[T]` to available in scope
    *
    * `implicitly[Adder[T]]` helps to capture the implicit value of type `Adder[T]` in scope
    *
    * This function can also be written as
    *    def add[T](value1: T, value2: T)(implicit adder: Adder[T]): T = adder.add(value1, value2)
    */
  def add[T : Adder](value1: T, value2: T): T = implicitly[Adder[T]].add(value1, value2)

  println(add(1, 2))     // Res: 3
  println(add("1", "2")) // Res: 12

  /*
  println(add(true, true))  // Compile time error:
                            // could not find implicit value for evidence parameter of type Adder[Boolean]
                            //
                            // To accept boolean type in function `add` you will have to define
                            // a implicit value that accepts Boolean similar to `StringAdder` and `IntAdder`
  */
}
