### A practise to learn how to use traits, to do stackable modifications 

Traits lets you modify the methods of a class, and they do so in a way that allows you to stack those
modifications with each other.

Problem

   Given a class that implements a queue, define traits to perform:
   
   Doubling: double all the elements that are put in the queue
   Incrementing: increment all integers that are put in the queue
   Filtering: filter out negative integers from a queue.
    
  ex: `abstract class IntQueue { 
        def get(): Int
        def put(x: Int)
      }`
