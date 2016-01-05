package func

///when the param is lambda
object FunctionTest2 {
  def main(args: Array[String]) {
    def test(code: => Unit) {
      println("start")
      code
      println("end")
    }
    test {
      println("when evaluated")
      println("bb")
    }

    def test1(code: Int) {
      println("start")
      println("end" +code)
    }
    test1{1}
  }
}
