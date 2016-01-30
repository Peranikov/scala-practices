package working_with_lists

object ListPatternSample extends App {
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() =>
      List()
    case x :: xs1 =>
      insert(x, isort(xs1))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() =>
      List(x)
    case y :: ys =>
      if (x <= y)
        x :: xs
      else
        y :: insert(x, ys)
  }

  println(isort(List(3, 2, 1))) // List(1, 2, 3)
  println(insert(4, List(3, 2, 1))) // List(3, 2, 1, 4)
}
