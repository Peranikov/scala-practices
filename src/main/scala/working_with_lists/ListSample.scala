package working_with_lists

object ListSample extends App {
  // list concatenation
  println(List(1, 2) ::: List(3, 4, 5))

  def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

  println(append(List.empty, List(1,2,3)))

  // tail and init
  val abcde = List('a', 'b', 'c', 'd', 'e')
  println(abcde.last)
  println(abcde.init)
}
