package edu.gemini.geom

/** A factory interface for creating `Shape`s. There would be a webapp version
  * and a backend version.  The webapp version for example could be
  * a `Shapes[paper.Path]` factory and the shapes it creates would be
  * `Shape[paper.Path]`.
  *
  * @tparam T underlying geometry class
  */
trait Shapes[T] {
  def rectangle(x: Double, y: Double, w: Double, h: Double): Shape[T]

  // polygon

  // circle
  // ellipse
}
