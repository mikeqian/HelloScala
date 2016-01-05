package cls

import scala.io.StdIn


///http://twitter.github.io/scala_school/zh_cn/advanced-types.html  视界（“类型类”）


object FunctionTest3 extends App {
  override def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()

    def isEven = (s:Int)=> s%2==0

    if (!isEven(n)){
      println("Weird")
      return
    }
    if ( (2<=n && n<=5) || n>20  ){
      println("Not Weird")
    }
    if ( (6<=n && n<=20)  ){
      println("Weird")
    }





  }


  def main3(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val m = sc.nextDouble()
    val t = sc.nextInt()
    val x = sc.nextInt()
    val price = m + (m * t) / 100 + (m * x) / 100

    println("The final price of the meal is $" + price.round + ".")
  }

}
