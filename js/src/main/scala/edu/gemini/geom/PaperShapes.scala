package edu.gemini.geom

object PaperShapes extends Shapes[paper.Path] {
  def rectangle(x: Double, y: Double, w: Double, h: Double): Shape[paper.Path] =
    new PaperShape(new paper.PathRectangle(new paper.Point(x, y), new paper.Size(w, h)))
}
