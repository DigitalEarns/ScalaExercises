package com.training.scala.getstarted

/**
 *  An exmaple of case class' usage along with pattern matching
 */
abstract class Expression
case class Var(name: String) extends Expression
case class Number(num: Double) extends Expression
case class UnOp(operator: String, arg: Expression) extends Expression
case class BinOp(operator: String, left: Expression, right: Expression) extends Expression

object CaseClassesObj {

  def main(args: Array[String]) {
    val v1 = Var("Simple")
    val op = BinOp("+", Number(1), v1)

    println("v1.name = " + v1.name)
    println("op.left = " + op.left)

    println("op = " + op)

    describe(v1)
    describe(op)

  }

  def describe(e: Expression): Unit = {
    e match {
      case Number(_)      => println ("It is a number")
      case Var(_)         => println ("It is a string expression")
      case UnOp(_,_)      => println ("It is a unary operation")
      case BinOp(_, _, _) => println ("It is a binary operation")
      case _              => println ("Invalid expression")
    }
  }
}
