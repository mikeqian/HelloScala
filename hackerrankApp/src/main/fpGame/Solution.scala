package main.fpGame

/**
  * Created by jsons on 2015/11/23.
  */
object Solution {

  def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        var n = sc.nextInt()


        var a = Array.ofDim[Int](n, n);
        for (a_i <- 0 to n - 1) {
          for (a_j <- 0 to n - 1) {
            a(a_i)(a_j) = sc.nextInt();
          }
        }


    def f(num: Int, arr: List[Int]): List[Int] = {
      arr.filter(_<num)
      var list = List[Int]()
      arr.foreach(a => (1 to num).foreach(b =>list = a:: list  ))
      return list.sortBy(a=>a)
    }
    val arr =( 1 to 10).toList
    val arr2 = List(-3, -2, 0, 1, 2, 3, 4)
    f(2, arr)

  }
}