package com.training.scala.getstarted

/**
 *  Getting started with List (one of the most used collections in Scala).
 *  Execute the main and observe the results to understand the usage of various functions over collections
 */
object Collections {

  def  covertToString(arg: Int): String =  arg.toString

  def main(args: Array[String]) {

    // `intList` is an immutable list of Int.
    val intList: List[Int] = List(1,2,3)

    // The function `map` in List type is a higher order function.
    // It accepts a function that operate on one element of a List at
    // a time. The argument function `maps` one element of list to another
    // type say, `U` .i.e once you apply the `map` function the result
    // you get back is a List[U].

    // here List[Int] is mapped to List[String]
    val newList: List[String] = intList.map(covertToString)

    val words = List("the", "quick", "brown", "fox")
    println(words.map(_.toList))

    // `flatMap` flattens the results after mapping.
    println(words.flatMap(_.toList))
    println(newList)

    // The interplay of map and flatMap is also demonstrated by the following expression,
    // which constructs a list of all pairs (i, j) such that 1 <= j < i < 5:
    println(List.range(1, 5) flatMap (i => List.range(1, i) map (j => (i, j))))
    println(List.range(1, 5) map (i => List.range(1, i) map (j => (i, j))))
    println(words.filter(_.length == 3))
    println(words.partition(_.length == 3))
    println(words.find(_.length == 3)
    )
  }
}
