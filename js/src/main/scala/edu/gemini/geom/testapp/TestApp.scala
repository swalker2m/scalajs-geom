package edu.gemini.geom.testapp

import edu.gemini.geom.paper.{Color, Paper}
import edu.gemini.geom.{Shape, Shapes, Point, PaperShapes}
import org.scalajs.dom.{Event, html, window}

import scala.scalajs.js.annotation.JSExport


@JSExport
object TestApp {

  /** A trivial example that illustrates how shapes can be specified
    * independent of the backing geometry library.
    *
    * Creates a rectangular shape at (10, 10) which is 5x5.  Obviously could
    * be done directly but this confirms that operations like intersect work.
    */
  def createShape[T](shapes: Shapes[T]): Shape[T] =
    shapes.rectangle(10, 10, 20, 20).intersect(shapes.rectangle(5, 5, 10, 10))

  @JSExport
  def main(canvas: html.Canvas): Unit = {

    // Unfortunately a setup method is required in order to do the geometry.
    // Paper.js mixes presentation and geometry.
    Paper.setup(canvas)

    // Create the shape using the PaperShapes factory. `rect` becomes a
    // Shape[paper.Path].  On the backend, you would use
    //
    //   createShape(Java2dShapes)
    //
    // and get a Shape[java.awt.Shape].
    val rect = createShape(PaperShapes)

    // Just check that the API methods like `contains` which we will need
    // work.
    val in   = new Point(12, 12)
    val out  = new Point(12, 16)
    println("12, 12 -> " + rect.contains(in))   // true
    println("12, 16 -> " + rect.contains(out))  // false

    // In the webapp, we can style the shapes and draw them.
    rect.raw.strokeColor = Color.Black
    Paper.view.draw()
  }
}
