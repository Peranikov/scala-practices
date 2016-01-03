package abstractions

import java.io.{File, PrintWriter}
import java.util.Date

object NewControlStructure extends App {
  def twice(op: Double => Double, x: Double) = op(op(x))

  println(twice(_ + 1, 5)) // 7.0

  // loan pattern
  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  withPrintWriter(
    new File("data.txt"),
    writer => writer.println(new Date())
  )

  // loan pattern(curried)
  def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  val file = new File("data.txt")
  withPrintWriter(file) { // this available curly brackets.
    writer => writer.println(new Date())
  }
}
