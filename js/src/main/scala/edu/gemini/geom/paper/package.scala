package edu.gemini.geom

package object paper {
  def colorRatio(i: Int): Double =
    (i.abs % 256)/255.0
}
