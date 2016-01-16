# A practise to learn how to use traits, to do stackable modifications 

Traits lets you modify the methods of a class, and they do so in a way that allows you to stack those
modifications with each other.

#### Problem

   Given a class that implements a queue, define traits to perform:
   
   Doubling: double all the elements that are put in the queue <br />
   Incrementing: increment all integers that are put in the queue <br/ >
   Filtering: filter out integers from a queue based on some condition.<br />
   
#### Things to be noted
   You can assume an underlying (integer) queue class with two methods, and they are `get` and `put`.
   Method `get` gets an element from queue(here, number) and Method `put` inserts the element into the queue.
   
   Doubling, Filtering and Incrementing can be considered as traits. <br/> They represent modifications, because
   they modify the behaviour of the underlying queue class rather than defining a full queue class themselves.
   
   These three modifications are also stackable, you can select any of the three you like, mix them into a class, and obtain a new
   class that has all of the modifications you choose.<br />
          
  Below given is the example of the queue
    
  You may start with: <br/>
  
  ```
  abstract class IntQueue {
  def get(): Int    
  def put(x: Int)
  }
  ```  
  
 