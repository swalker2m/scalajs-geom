package edu.gemini.geom

import scala.scalajs.js.annotation.JSExportAll

/** Generic definition of a shape, for example a probe arm, probe arm range
  * limits, detector area, etc.  These are often built up from adding,
  * subtracting, intersecting simpler shapes.
  *
  * @tparam T underlying shape library type
  */
@JSExportAll
trait Shape[T] {
  def raw: T

  def contains(p: Point): Boolean

  def add(s: Shape[T]): Shape[T]

  def subtract(s: Shape[T]): Shape[T]

  def intersect(s: Shape[T]): Shape[T]

  def xor(s: Shape[T]): Shape[T]

  // ....
  // rotate
  // translate
  // scale
  // transform(matrix)
  // etc ...
}
