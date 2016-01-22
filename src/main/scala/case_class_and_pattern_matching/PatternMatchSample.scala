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

  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  println(generalSize("abc"))
  println(generalSize(Map(1 -> "a", 2 -> "b")))
  println(generalSize(math.Pi))

  def tupleDemo(expr: Any) = {
    expr match {
      case (a, b, c) => "matched " + a + b + c
      case _ =>
    }
  }

  println(tupleDemo(("a ", 3, "-tuple")))

  val user2 = User(UserId(1), 20, "Jan")
  println(
    user2 match {
      case User(id @ UserId(1), 20, "Jan") => id
      case _ =>
    }
  )
}
