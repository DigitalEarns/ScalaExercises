package com.problems.higherorderfunctions

object HOFunctions {

  def main(args: Array[String]) {

    def checkOdd(n:Int): Boolean  = if (n % 2 != 0) true else false
    def checkEven(n:Int): Boolean = if (n % 2 == 0) true else false

    val numbers: List[Int] = List(1,4,3,6,8,10,49,50,33,60)

    //get the numbers which are odd
    val oddList  = numbers.filter(checkOdd(_))

    //get the numbers which are even
    val evenList = numbers.filter(checkEven(_))

    println(s"Odd  = ${oddList}")
    println(s"Even = ${evenList}")

    // function to double a given number
    def doubleNumber = (x: Int) => x * 2

    // function to add one to a number
    def addOne = (x: Int) => x + 1

    // example of a function which returns another function of type (Int => Int)
    def doOperation(x: Int): (Int => Int) = {
      if (checkEven(x))
        doubleNumber
      else
        addOne
    }

    // for each number in the list, it gets f (which is a function either doubleNumber or addOne) and apply f to it.
    val alteredList = numbers.map { x =>
      val f = doOperation(x)
      f(x)
    }
    println(s"New List = ${alteredList}")
  }
}
