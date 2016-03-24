package edu.gemini.geom

import java.awt.geom.Rectangle2D

object Java2dShapes extends Shapes[java.awt.Shape] {
  def rectangle(x: Double, y: Double, w: Double, h: Double): Shape[java.awt.Shape] =
    new Java2dShape(new Rectangle2D.Double(x, -(y + h) - h, w, h))
}

