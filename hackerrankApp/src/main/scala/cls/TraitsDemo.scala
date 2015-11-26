package cls

import scala.language.implicitConversions

///http://twitter.github.io/scala_school/zh_cn/advanced-types.html  视界（“类型类”）
trait Similarity {
  def isSimilar(x: Any): Boolean
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}
class Point(xc: Int, yc: Int) extends Similarity {
  var x: Int = xc
  var y: Int = yc
  def isSimilar(obj: Any) =
    obj.isInstanceOf[Point] &&
      obj.asInstanceOf[Point].x == x
}

object TraitsDemo {
  def main(args: Array[String]) {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)
    println(p1.isNotSimilar(p2))
    println(p1.isNotSimilar(p3))
    println(p1.isNotSimilar(2))

  }
}
