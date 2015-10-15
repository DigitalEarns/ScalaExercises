import scala.annotation.tailrec

object ListUtils {
  // function to return the last element of a list
  def lastElement(x: List[Int]): Int = {
    x.reverse.head
  }

  // function to find the second last element of a list using pattern matching
  // TBD other easie methods if any ??
  def secondLastElement(x: List[Int]): Int = {
    def findElement[Int](j: List[Int]): Int = j match {
      case x :: _ :: Nil => x
      case _ :: tail     => findElement(tail)
      case _             => throw new NoSuchElementException
    }
    findElement(x)
  }

  // find the kth element of a list
  def findKthElement (x:List[Int], k: Int) = {
    x.take(k).reverse.head
  }

  // find the count of elements in a list
  def countOfElements (x: List[Int]) = {
    x.length
  }

  // reverse of a given list
  def reverseList (x: List[Int]) = {
    x.reverse
  }

  // function to remove consecutive duplicate elements and replace with a single copy
  def removeDuplicates (x: List[Int]): List[Int] = {
    def deDup(seen: List[Int], remaining: List[Int]): List[Int] =
      remaining match {
      case Nil                      => seen
      case x :: y :: xs if (x == y) => deDup(seen, y :: xs)
      case x :: xs                  => deDup(seen ::: List(x), xs)
    }
    deDup(Nil, x)
  }

  def sortListwithSubList (x: List[List[Int]]) = {
     x.sortWith(_.length < _.length)
  }
}

object Session1 {
  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 5, 5, 8)
    val subList = List(List(1,2), List(3), List(3,4,5), List(8))
    println("Last Element                  = " + ListUtils.lastElement(l))
    println("Seocnd Last Element           = " + ListUtils.secondLastElement(l))
    println("3rd element of the list       = " + ListUtils.findKthElement(l, 3))
    println("Count of elements in the list = " + ListUtils.countOfElements(l))
    println("Reverse of the list           = " + ListUtils.reverseList(l))
    println("After removing cons dups      = " + ListUtils.removeDuplicates(l))
    println("Sorting based on sublist size = " + ListUtils.sortListwithSubList(subList))
  }
}
