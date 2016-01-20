package case_class_and_pattern_matching
import math.{E, Pi}

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
}
