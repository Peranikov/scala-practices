package abstractions

object ByNameParameters extends App {
  var assertionsEnabled = true

  def myAssert(predicate: () => Boolean) =
    if (assertionsEnabled && !predicate())
      throw new AssertionError

  myAssert(() => 5 > 3) // myAssert(5 > 3) と書きたい

  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  byNameAssert(5 > 3)

  def boolAssert(predicate: Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  boolAssert(5 > 3) // この書き方は `boolAssert` 呼び出し前に括弧内が評価される

  assertionsEnabled = false

  byNameAssert(1 / 0 == 0) // 括弧内が評価されないので例外が発生しない
  boolAssert(1 / 0 == 0)   // 括弧内が評価されるので例外が発生する
}
