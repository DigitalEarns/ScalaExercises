package com.training.scala.getstarted.types

/**
  * Context Bound defines that a implicit value should be available in scope to call a function.
  *
  * Example:
  * {{{
  *   def fun[A : B](a: A) = a.get()
  * }}}
  *
  * For `fun` a implicit value of type B[A] should be available in the functions scope
  *
  * The above function can also be written as
  * {{{
  *   def fun[A](a: A)(implicit value: B[A]) = a.get()
  * }}}
  *
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

/** A Note on the difference between ViewBounds and ContextBounds
  * For those who have also gone through ViewBounds (explained in this project)
  * and need to get more clarification around the
  * actual difference between ViewBounds and ContextBounds, please refer to the below notes:
  * ContextBounds (ie, A : B) enforce the existance of an implicit value of type B[A], where as
  * ViewBounds (ie, A <% B) enforce the existance of an actual implicit conversion from A to B,
  * A few try outs with viewbounds and context bounds is necessary here:
  *
             // works fine, as explained before
    scala>   def fun[A : Ordered](a: A) = a
             fun: [A](a: A)(implicit evidence$1: Ordered[A])A

             // below function doesn't make sense as per the definition of type parameters
    scala>   def fun[A: Ordered[A]](a: A) = a
             <console>:7: error: Ordered[A] does not take type parameters
             def fun[A: Ordered[A]](a: A) = a
                  ^
             // works fine , both `a` and `b` act as something that can be ordered.
    scala>   def fun[A <% Ordered[A]](a: A, b: A) = if (a < b) a else b
             fun: [A](a: A)(implicit evidence$1: A => Ordered[A])A

             // works fine, `a` can act as a string now
    scala>   def fun[A <% String](a: A) = a
             fun: [A](a: A)(implicit evidence$1: A => String)A

             // below function doesn't make sense as per the definition of context bounds
    scala>   def fun[A : String](a: A) = a
             <console>:7: error: String does not take type parameters
             def fun[A : String](a: A) = a
                   ^

  * If this is still unclear, please note the difference between the below two functions:
  * {{{ def fun[A <% B](a: A) = a.someFunctionInB }}} // a can call a function in B
  * {{{ def fun[A : B](a: A) = g(a) }}} // where g requires an implicit value of type B[A]
  *
  * See below how they de-sugar:
  * {{{ def f[A <% B](a: A) = a.someFunctionInB }}}
  * {{{ def f[A](a: A)(implicit ev: A => B) = a.someFunctionInB }}}
  *
  * {{{ def f[A : B](a: A) = g(a) }}}
  * {{{ def g[A](a: A)(implicit ev: B[A]) = g(a) }}}
  */
}
