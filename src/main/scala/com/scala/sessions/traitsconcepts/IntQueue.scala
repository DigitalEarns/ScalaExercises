package com.scala.sessions.traitsconcepts

/**
  * As per the problem, lets define the underlying queue.
  * To make things simple, let it be an intqueue, with
  * a get method and put method in it. These methods
  * are not defined and is dependent on the type of intqueue.
  */
abstract class IntQueue {
 def get(): Int
 def put(x: Int)
}

/** Let us define one type of the int queue. Lets name it as
  * BasicIntQueue. It has concrete implementation of get and put
  * methods
  */
class BasicIntQueue extends IntQueue {
  import scala.collection.mutable.ArrayBuffer
  val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = buf += x
  override def toString = buf.size.toString
}

/** Doubling logic, that doubles the numbers
  * put on queue. For this we can have a trait that can actually
  * modify the existing logic of put in `IntQueue`
  */
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { print("doubling; "); super.put(x * 2) }
}

/** Filtering logic, that doubles the numbers
  * put on queue. For this we can have a trait that can actually
  * modify the existing logic of put in `IntQueue`
  */
trait Filtering extends IntQueue {
  abstract override def put(x: Int) =
    if(x > 1) { print("filter passed; "); super.put(x) }
}

/** Incrementing logic, that doubles the numbers
  * put on queue. For this we can have a trait that can actually
  * modify the existing logic of put in `IntQueue`
  */
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { print ("incrementing; ");  super.put (x + 1) }
}

/** testing the three trait behaviours */
object TestingStackableModification {
  def main(args: Array[String]) {
    // instantiating various mixed behaviour queues
    val simpleDoublingQueue              =  { new BasicIntQueue with Doubling }
    val mixedBehaviourQueue              =  { new BasicIntQueue with Doubling with Filtering }
    val incrementedFilteredDoublingQueue =  { new BasicIntQueue with Doubling with Filtering with Incrementing }

    // returns "doubling; 4 "
    simpleDoublingQueue.put(2)
    println (simpleDoublingQueue.get())

    // returns "filter passed; doubling; 4"
    mixedBehaviourQueue.put(2)
    println (mixedBehaviourQueue.get())

    //returns "incrementing; filter passed; doubling 4"
    incrementedFilteredDoublingQueue.put(1)
    println (incrementedFilteredDoublingQueue.get())
  }
}

// Note: The so called diamond inheritance problem is resolved here, by making use of
// Linearization, where compiler finds out a proper order for the parents of a class and assigns the appropriate
// method. It will never have any confusion of on which parent has to be used to find out the implementation of a
// method.