package main.fpGame

import scala.collection.immutable.Seq


object BigSanjiao {


  //cut a triangle and return three
  def cutTri(top: Seq[Seq[(Int, Int)]]): List[Seq[Seq[(Int, Int)]]] = {
    val headRow = top.head.head._1
    val lastRow = top.last.last._1
    val cutRowIndex = (headRow + lastRow + 1) / 2
    if (lastRow == headRow) return top :: Nil
    //a big triangle is cut be three triangle ,top left right
    val topWithRow = top.map(a => (a -> a.head._1))

    val r1 = topWithRow.filter(_._2 < cutRowIndex).map(_._1)
    val r2 = topWithRow.filter(_._2 >= cutRowIndex).map(rowzip => rowzip._1.take((rowzip._2 - cutRowIndex) * 2 + 1))
    val r3 = topWithRow.filter(_._2 >= cutRowIndex).map(rowzip => rowzip._1.drop(rowzip._1.length - (rowzip._2 - cutRowIndex) * 2 - 1))

    return r1 :: r2 :: r3 :: Nil
  }

  def docut(triangles: List[Seq[Seq[(Int, Int)]]], num: Int):
  List[Seq[Seq[(Int, Int)]]] = (triangles, num) match {
    case (triangles, num) if num <= 0 => triangles
    case (triangles, num) => docut(triangles.map(a => cutTri(a)).flatMap(a => a), num - 1)
  }

  def printTriangle(points: List[(Int, Int)]): Unit = {
    (0 to 31).foreach(r => {
      (0 to 62).foreach(c => if (points.indexOf(r -> c) >= 0) print("1") else print("_"))
      print("\n")
    })
  }

  def drawTriangles(n: Int) {
    //Draw the N'th iteration of the fractal as described
    // in the problem statement
    //There are 32 rows and 64 -1
    //create the top big  triangle , first create row then create column, a tuple is a point
    val top = (0 to 31).map(row => ((31 - row) to (31 + row)).map((row -> _)))

    val rows = docut(top.toList :: Nil, n).flatMap(triangle => triangle)
    val points = rows.flatMap(a => a)
    printTriangle(points)

    var size = points.length
  }


  def main(args: Array[String]) {
    //drawTriangles(readInt())
    drawTriangles(5)
  }

}


/**
  * Created by jsons on 2015/11/25.
  */





