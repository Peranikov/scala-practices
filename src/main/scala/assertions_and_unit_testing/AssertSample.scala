package assertions_and_unit_testing

object AssertSample extends App {
  def assertTest(i: Int): Unit = {
    assert(i > 1)
  }

//  assertTest(1 // AssertionError: assertion failed
  assertTest(2)

  def ensuringTest(i: Int): Int = {
    if (i > 0) {
      i
    } else {
      Math.abs(i)
    } ensuring(_ > 1)
  }

//  ensuringTest(-1) // AssertionError: assertion failed
  ensuringTest(2)
}
