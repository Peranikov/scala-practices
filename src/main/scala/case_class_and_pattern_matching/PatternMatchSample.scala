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

  println(
    UserId(1) match {
      case UserId(x) if x == 1 => "id = 1"
    }
  )

  sealed abstract class Animal
  case class Dog() extends Animal
  case class Cat() extends Animal
  case class Sheep() extends Animal

  def howl(a: Animal): String = {
    a match {
      case Dog() => "Bow wow"
      case Cat() => "Mew mew"
//      case Sheep() => "Maa maa" // warn: match may not be exhaustive.
    }
  }

  def matchOption(x: Option[Int]): String = {
    x match {
      case Some(s) => s"Some: $s"
      case None => "None"
    }
  }


  println(matchOption(Some(1)))
  println(matchOption(None))

  // variable pattern
  val myTuple = (123, "abc")
  val (number, string) = myTuple
  println(number)
  println(string)

  case class Sample(a: String, b: Int, c: Seq[Char])

  val sample = Sample("x", 100, Seq('h', 'j', 'k'))
  val Sample(a, b, c) = sample
  println(a)
  println(b)
  println(c)

  // PartialFunction
  val second: List[Int] => Int = {
    case x :: y :: _ => y
  }

  println(second(List(5, 6, 7)))
//  println(second(List())) // scala.MatchError: List()

  val partialSecond: PartialFunction[List[Int], Int] = {
    case x :: y :: _ => y
  }

  println(partialSecond.isDefinedAt(List(5, 6, 7)))
  println(partialSecond.isDefinedAt(List()))

  // Tuple pattern with for
  val capitals = Map("USA" -> "NewYork", "Japan" -> "Tokyo")
  for((country, city) <- capitals)
    println(s"The capital of $country is $city")

  val results = List(Some("apple"), None, Some("orange"))
  for (Some(fruit) <- results) println(fruit)
}
