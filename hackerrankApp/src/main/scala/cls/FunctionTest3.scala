package cls

import scala.language.implicitConversions

///http://twitter.github.io/scala_school/zh_cn/advanced-types.html  视界（“类型类”）


object FunctionTest3 {
  def main(args: Array[String]) {

    var words = 'a' to 'z'


    implicit def strToInt(x: String) = x.toInt

    class Container[A <% Int] {
      def addIt(x: A) = 123 + x
    }
    class Container3[A](value: A) {
      def addIt(implicit evidence: A ) = 123
    }
    class Container34[A](value: A) { def addIt(implicit evidence: A =:= Int) = 123 + value }



    class Container2[A](value: A) {
      def addIt(implicit evidence: A =:= Int) = 123 + value
    }
    implicit def intToString222(i: Int) = i.toString

    def bar(msg: String) = println("aslo can use implicit function intToString...result is " + msg)

  }
}
