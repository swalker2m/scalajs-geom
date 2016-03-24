package edu.gemini.geom

import edu.gemini.geom.paper.{Path => PShape}

import scala.scalajs.js.annotation.JSExportAll

@JSExportAll
final class PaperShape(val raw: PShape) extends Shape[PShape] {

  def contains(p: Point): Boolean =
    raw.contains(new paper.Point(p.x, p.y))

  private def combineWith(s: Shape[PShape])(f: (PShape, PShape) => PShape): Shape[PShape] =
    new PaperShape(f(raw, s.raw))

  override def add(s: Shape[PShape]): Shape[PShape] =
    combineWith(s)(_.unite(_))

  override def subtract(s: Shape[PShape]): Shape[PShape] =
    combineWith(s)(_.subtract(_))

  override def intersect(s: Shape[PShape]): Shape[PShape] =
    combineWith(s)(_.intersect(_))

  override def xor(s: Shape[PShape]): Shape[PShape] =
    combineWith(s)(_.exclude(_))
}
