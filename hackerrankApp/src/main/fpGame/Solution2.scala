package main.fpGame

object Solution2 extends App {
  def f(num: Int, arr: List[Int]): List[Int] = {
    val re = arr.flatMap(e => List.fill(num)(e))
    re
  }

  //jiecheng
  def factorial(in: Long): Long = in match {
    case 0 => 1
    case 1 => 1
    case n: Long => n * factorial(n - 1)
  }

  def getColumn(row: Int, column: Int): Int = (row, column) match {
    case (n, r) if r == 0 || n == 0 => 1
    case (n, r) if r ==n  => 1
    case (n, r) => (factorial(n) / (factorial(r) * factorial(n - r))).toInt
  }

  // n! / (r! * (n-r)!)
  def getRowStr(row: Int) = {
    val n = row
    (0 to n).map(r => getColumn(n, r)).mkString(" ")
  }

  // val sc = new java.util.Scanner(System.in)
  var n = 10
  (0 to n - 1).map(getRowStr).foreach(println) // indexing start from 0


  def mysum = (x:Int,y:Int)=> x+y
  def mydiff = (x:Int,y:Int) => math.abs(x-y)





  val arr = (1.0 to(10, 0.1))

  val re = -3 % 2



}