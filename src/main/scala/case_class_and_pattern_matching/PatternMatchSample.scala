package case_class_and_pattern_matching
import math.{E, Pi}

case class UserId(id: Int)
case class User(id: UserId, age: Int, name: String)

object PatternMatchSample extends App {
  println(
    E match {
      case Pi => "strange math? Pi = " + Pi
      case _ => "OK"
    }
  ) // "OK"

  val pi = math.Pi
  println(
    E match {
      case pi => "strange math? Pi = " + pi
      case _ => "OK" // unreachable code
    }
  ) // "strange math? Pi = 2.718281828459045"

  println(
    E match {
      case `pi` => "strange math? Pi = " + pi // 定数として解釈する
      case _ => "OK" // unreachable code
    }
  ) // "OK"

  val user = User(UserId(1), 20, "Jan")
  println(
    user match {
      case User(UserId(1), 20, "Jan") => "found it."
      case _ => "not found"
    }
  ) // "found it."

  val list = List(0, 1, 2)
  println(
    list match {
      case List(0, _, _) => "match List "
      case _ => "not match List"
    }
  )

  println(
    list match {
      case List(0, _*) => "match List "
      case _ => "not match List"
    }
  )
}
