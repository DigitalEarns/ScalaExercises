package com.training.scala.getstarted

/*
  Getting started using for comprehensions

  Scala’s “for comprehensions” are syntactic sugar for composition of multiple operations
  with foreach, map, flatMap, filter or withFilter. Scala actually translates a for-expression into calls to
  those methods, so any class providing them, or a subset of them, can be used with for comprehensions.

  Given are a few simple examples.

  Run the code and see the results
*/

case class Employee(id: String, name: String, salary: Long)

object ForYieldExample {
  def main(args: Array[String]) {

    val ex1 = for (i <- 10 until (0, -2))
      yield i
    println(s"Example1 result = ${ex1}")

    val ex2 = for (i <- 1 to 10 if i % 2 == 0)
      yield i
    println(s"Example2 result = ${ex2}")

    /** example of using for comprehension and writing the same logic using a flatMap */
    val ex3 = for (i <- 1 to 10; j <- 1 until i)
      yield (i, j)
    println(s"Example3 result = ${ex3}")

    val ex3Similar = (1 to 10)
      .flatMap(x => (1 until x).map(y => (x, y)))
    println(s"ex3Similar = ${ex3Similar}")

     /*
      * Another example, from a given list of Employees, find whose name starts with "J" and has a salary > 12000
      *
      * Also append the current time stamp to the result (Result will have only "name|time")
      */
    val lst = List(
      Employee("EMP1", "John", 20000),
      Employee("EMP2", "Jose", 10000),
      Employee("EMP3", "Sam", 15000),
      Employee("EMP4", "Tom", 12000)
    )
    val dt = new java.util.Date().getTime

    // implementation using filter & map combination, followed by equivalent for comprehension
    val res = lst
      .filter(x => x.salary > 12000 && x.name.startsWith("J"))
      .map(x => s"${x.name}|${dt}")
    println("result with map and filter = " + res)

    val res1 = for {
      x <- lst if (x.salary > 12000 && x.name.startsWith("J"))
      y = s"${x.name}|${dt}"
    } yield y

    println("result with for comprehension = " + res1)
  }
}
