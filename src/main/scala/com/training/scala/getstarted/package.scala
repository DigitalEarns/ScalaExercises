package com.training.scala

/*
   Introducing Package Objects: If you want to make functions, fields etc available to all classes in a package,
   without requiring to have a class or object, make use of package objects.

   Reference: https://www.safaribooksonline.com/library/view/scala-cookbook/9781449340292/ch06s08.html
*/
package object getstarted {
  val commonVal = "an example of package object"
  // this is a simple example without and guards to see if the conversion is success or failure.
  def convertToDouble(str: String) = str.toDouble

}
