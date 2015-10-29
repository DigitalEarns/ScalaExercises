
# Getting a sense of Partial Function in Scala
 

Context

See the behaviour of `List(41, "cat") map { case i: Int ⇒ i + 1 }`

and look at `List(41, "cat") collect { case i: Int ⇒ i + 1 }`

Identify the difference between map and collect !

1. Implement the function given below using PartialFunction in Scala

   `def fraction(d: Int) = 30 / d`. 

2. Implement increment function for a list of elements of Any type. Increment should be applicable only for Int values.

ie. def incAny(x: Int) = x + 1 (this is the basic function), but it should be applied only for type Int

ie: List (41, "String") collect incAny should return

Ans: List(42)

