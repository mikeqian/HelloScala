package func

///函数示例 斐波那契: case语句


object FunctionTest1 {
  def main(args: Array[String]) {
    abstract class Expr

    case class FibonacciExpr(n: Int) extends Expr {
      require(n >= 0)
    }
    case class SumExpr(a: Expr, b: Expr) extends Expr

    def value(in: Expr): Int = in match {
      case FibonacciExpr(n) if n < 2 => if (n == 1) 1 else 0
      case FibonacciExpr(n) =>
        value(SumExpr(FibonacciExpr(n - 1), FibonacciExpr(n - 2)))
      case SumExpr(a, b) => value(a) + value(b)
      case _ => 0
    }
    println(value(FibonacciExpr(6)))


    class Foo {
      val Name = "FooClass"

      def showName = () => {
        print(Name)
      }
    }
    object Foo {

      def apply() = new Foo()
    }
    object FooMaker {
      def apply() = new Foo()
    }
    object addOne extends ((Int) => Int) {
      def apply(m: Int): Int = m + 1
    }

    val foo = FooMaker()
    println(foo.Name)
    val b1 = true
    val b2 = false
    val b3 = b1 && b2

  }
}
