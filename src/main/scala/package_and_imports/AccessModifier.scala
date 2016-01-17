package package_and_imports

class Outer {
  class Inner {
    private def f() { println("f") }

    class InnerMost {
      f() // OK
    }
  }

//  (new Inner).f() // Error: Can't access.
}

package p {
  class Super {
    protected def f() { println("f") }
  }

  class Sub extends Super {
    f()
  }

  class Other {
//    (new Super).f() // Error: Can't access.
  }
}