package com.training.scala.getstarted

/**
 *  Getting started with List (one of the varities of collections in Scala
 *  Execute the main and observe the results to understand the usage of various functions over collections
 */
object Collections {
  def main(args: Array[String]) {

    val intList: List[Int] = List(1,2,3)
    val newList: List[Int] = intList.map(_ * 2)

    val words = List("the", "quick", "brown", "fox")
    println(words.map(_.toList))
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
