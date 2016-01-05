package main.fpGame

import scala.io.StdIn

/**
  * Created by jsons on 2015/11/23.
  */
object Solution extends App{

  def evenRev(str:String) = {
    val l11 = str.zipWithIndex.filter(p => p._2 % 2 == 0).map(_._1) //ac
    val l12 = str.zipWithIndex.filter(p => p._2 % 2 == 1).map(_._1) //bd
    l12.zip(l11).map( a=>a._1.toString+a._2.toString).mkString("")
  }

  override def main(args: Array[String]) {
    var l31 = "abcd".zip("efgh").map( a=>a._1.toString+a._2.toString).mkString("")

    val s = "abcdefgh"
    val ans = for (i <- 0 until s.length) yield s(i^1)

    ( 0 until 10).foreach(a=>print(a^1))

    val sc = new java.util.Scanner(System.in)
    var n = sc.nextInt()
    if (sc.hasNext()){
      val sss = sc.nextDouble()
      StdIn.readLine()
    }

    (1 to n).foreach(a=>println(evenRev(sc.nextLine())))

    var l1 = sc.nextLine()
    var l2 = sc.nextLine()
    var l3 = l1.zip(l2).map( a=>a._1+a._2).mkString("")
    println(l3)

    var a = Array.ofDim[Int](n, n);
    for (a_i <- 0 to n - 1) {
      for (a_j <- 0 to n - 1) {
        a(a_i)(a_j) = sc.nextInt();
      }
    }


    def f(num: Int, arr: List[Int]): List[Int] = {
      arr.filter(_ < num)
      var list = List[Int]()
      arr.foreach(a => (1 to num).foreach(b => list = a :: list))
      return list.sortBy(a => a)
    }
    val arr = (1 to 10).toList
    val arr2 = List(-3, -2, 0, 1, 2, 3, 4)
    f(2, arr)

  }
}