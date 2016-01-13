package traits

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  override def get(): Int = buf.remove(0)

  override def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

class MyQueue extends BasicIntQueue with Doubling

object MyQueueSample extends App {
  val queue = new MyQueue
  queue.put(10)
  println(queue.get()) // 20
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

object MixInSample extends App {
  val queue = (new BasicIntQueue with Incrementing with Filtering)
  queue.put(-1); queue.put(0); queue.put(1);
  println(queue.get()) // 1
  println(queue.get()) // 2
}

object MixInSample2 extends App {
  val queue = (new BasicIntQueue with Filtering with Incrementing)
  queue.put(-1); queue.put(0); queue.put(1);
  println(queue.get()) // 0
  println(queue.get()) // 1
  println(queue.get()) // 2
}