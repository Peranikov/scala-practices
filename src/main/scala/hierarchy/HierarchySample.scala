package hierarchy

object HierarchySample extends App {
//  new Int // class Int is abstract

  println(42 max 43)

  println(42 min 43)

  println(1 until 5)

  println(1 to 5)

  println(3.abs)

  println((-3).abs)

  val x = new String("abc")
  val y = new String("abc")

  println(x == y) // true
  println(x eq y) // false
  println(x ne y) // true

//  val i: Int = null // type mismatch
  def divide(x: Int, y: Int): Int = {
    if (y != 0) x / y
    else sys.error("can't divide by zero") // sys.errorはNothingを返すので戻り値のIntの条件を満たす
  }
}
