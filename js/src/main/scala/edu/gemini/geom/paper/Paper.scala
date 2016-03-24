package edu.gemini.geom.paper

import org.scalajs.dom.html
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

// Facade for the parts of Paper.js that we use.  This would be fleshed out as
// needed.

@js.native
@JSName("paper.Color")
class Color(r: Double, g: Double, b: Double) extends js.Object {
  def this(r: Int, g: Int, b: Int)  =
    this(colorRatio(r), colorRatio(g), colorRatio(b))
}

object Color {
  val Black = new Color(0, 0, 0)
}

@js.native
@JSName("paper.Item")
class Item extends js.Object {
  var name: String = js.native

  def contains(point: Point): Boolean = js.native
}

@js.native
class PaperScope extends js.Object {
  val view: View = js.native
  def setup(canvas: html.Canvas): Unit = js.native
}

@js.native
object PaperScope extends js.Object {
  def get(id: Int): PaperScope = js.native
}

@js.native
@JSName("paper")
object Paper extends PaperScope

@js.native
@JSName("paper.PathItem")
class PathItem extends Item {
}

@js.native
@JSName("paper.Path")
class Path extends PathItem {
  var strokeColor: Color = js.native

  def unite(p: Path): Path = js.native
  def intersect(p: Path): Path = js.native
  def subtract(p: Path): Path = js.native
  def exclude(p: Path): Path = js.native
}

@js.native
@JSName("paper.Point")
class Point(x: Double, y: Double) extends js.Object {

}

object Point {
  val origin = new Point(0, 0)
}


@js.native
@JSName("paper.Path.Rectangle")
class PathRectangle protected() extends Path {
  def this(point: Point, size: Size) = this()
}

@js.native
@JSName("paper.Size")
class Size(val width: Double, val height: Double) extends js.Object {

}

@js.native
@JSName("paper.View")
class View extends js.Object {
  def draw(): Unit = js.native
  def update(force: Boolean = true): Boolean = js.native
}