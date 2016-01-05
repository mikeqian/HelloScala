package func

///类型推断


object FunctionTest3 {
  def main(args: Array[String]) {

    //边界
    //def cacophony[T](things: Seq[T]) = things map (_.sound)

    def fibonacci(in: Any): Int = in match {
      case 0 => 0
      case 1 => 1
      case n: Int if (n > 1) => fibonacci(n - 1) + fibonacci(n - 2)
      case n: String => fibonacci(n.toInt)
      case _ => 0
    }
  }

  def count[A](l: List[A]) = l.size

  def count2(l: List[_]) = l.size

  def count3(l: List[T forSome {type T}]): Int = l.size

  def drop1(l: List[T forSome {type T}]) = l.tail


    val file = List("warn 2013 msg", "warn 2012 msg", "error 2013 msg", "warn 2013 msg")
  //var sum = file.last.split(' ').map(_.toInt).sum
    val size = file.filter(_.contains("warn")).filter(_.contains("2013")).size
    //val size1 = file.filter(_.contains("warn") && _.contains("2013")).size
    val size2 = file.filter( a=> a.contains("warn") &&  a.contains("2013")).size
    println("cat file | grep 'warn' | grep '2013' | wc : "  +size )


  val file2 = List("warn 2013 msg", "warn 2012 msg",
    "error 2013 msg", "warn 2013 msg")

  def wordcount(str: String): Int = str.split(" ").count("msg" == _)

  val num = file2.map(wordcount).reduceLeft(_ + _)

  case class Animal(sound: String) {

  }

  class Chicken

  class Bird

}
