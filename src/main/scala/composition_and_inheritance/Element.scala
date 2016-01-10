package composition_and_inheritance
import Element.elem

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def adove(that: Element): Element = {
    elem(this.contents ++ that.contents)
  }

  def beside(that: Element): Element = {
    elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  }

  override def toString = contents mkString "\n"
}

object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)
}

//class ArrayElement(conts: Array[String]) extends Element {
//  def contents: Array[String] = conts
//}

// parameter field version
class ArrayElement(val contents: Array[String]) extends Element

class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}

class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}

object ElementTest extends App {
  val e1: Element = new ArrayElement(Array("hello", "world"))
  val ae: Element = Element.elem("hello")
  val e2: Element = ae
  val e3: Element = new UniformElement('x', 2, 3)
}