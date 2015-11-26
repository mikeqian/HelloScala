import scala.collection.immutable.NumericRange.Inclusive

///
object listDemo {
  def main(args: Array[String]) {
    val numbers: List[Int] = List(1, 2, 3, 4);

    val hostPort = ("localhost", 80)
    val str: Int = hostPort._2

    val map = Map("foo" -> "bar")
    val map2 = Map("timesTwo" -> {
      map(_)
    })

    val chars: Inclusive[Char] = 'a' to 'z'
    def drop1[A](l: List[A]) = l.tail

    val chars2 = chars.map(c=>Map(c ->( c.toInt -'a'.toInt+1)))

    print(chars2)

  }
}
