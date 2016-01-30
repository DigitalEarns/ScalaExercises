package com.training.scala.getstarted

/**
 * An example on the usage of Options.
 *
 * Option is a data type in Scala that explicitly tells the user
 * about absence of some value. If you have worked with java, you
 * might have come across with NullPointer exceptions at some time.
 * It happens when you are expecting some value and you end up with a
 * null reference which not not properly handled. A common example is
 * we have lookup Map<String, String>. If we perform a `get` operation
 * with a key that is not there in the map, it will return a null
 * (absence of a value), but the return type of the `get` method (`java.lang.String`)
 * doesn't explicitly tell this.
 *
 * The Option data type avoids this scenario by making it explicit that
 * there is a chance of absence of value of particular Type.
 *
 *
 */
object OptionObject {
  def main(args: Array[String]) {

    // In Scala the Map's get operation returns an Option.
    // That is if we have a Map[String, String]. The signature of `get` method is
    //
    //  def get(arg: String): Option[String].
    //
    // The Option[T] has exactly two subclasses  Some[T] and None.
    // Where `Some[T]` indicates (& wraps the value itself) presence of value of type T
    // and `None` indicates absence of value of Type T
    //
    // thus by saying the return type of the method is Option[String],
    // its clear that the `get` operation may or may not return a value of type String
    val capitals = Map(
      "France"    -> "Paris",
      "India"     -> "Delhi",
      "Australia" -> "Canberra",
      "Japan"     -> "Tokyo"
    )

    // see the output to see the values being returned
    println(capitals.get("France"))
    println(capitals.get("Argentina"))

    checkPresenceOfInteger(toInt("10"))
    checkPresenceOfInteger(toInt("ABC"))
  }

  // function to convert a given string to Int
  // By making the return type as Option[Int] its
  // clear from the definitions itself that the function
  // may or may not return a value of type Int.
  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: NumberFormatException => None
    }
  }

  def checkPresenceOfInteger(arg: Option[Int]) = arg match {
    // code to hanlde the integer value
    case Some(x) => println(s"An integer value is present = $x")
    // code to handle the absence of integer value
    case None    => println("Denotes absence of integer value")
  }
}
