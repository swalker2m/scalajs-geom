package edu.gemini.geom

import java.awt.geom.Area
import java.awt.{Shape => JShape}

import scalaz.Scalaz._

final class Java2dShape(val raw: JShape) extends Shape[JShape] {

  def contains(p: Point): Boolean =
    raw.contains(p.x, -p.y)

  private def combineWith(s: Shape[JShape])(f: (Area, Area) => Unit): Shape[JShape] =
    new Java2dShape(new Area(raw) <| (a => f(a, new Area(s.raw))))

  def add(s: Shape[JShape]): Shape[JShape] =
    combineWith(s) { _.add(_) }

  def subtract(s: Shape[JShape]): Shape[JShape] =
    combineWith(s) { _.subtract(_) }

  def intersect(s: Shape[JShape]): Shape[JShape] =
    combineWith(s) { _.intersect(_) }

  def xor(s: Shape[JShape]): Shape[JShape] =
    combineWith(s) { _.exclusiveOr(_) }
}
