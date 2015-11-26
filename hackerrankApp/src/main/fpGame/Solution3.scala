package main.fpGame

object Solution3 {

  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients:List[Int],powers:List[Int],x:Double):Double =
  {
    ((coefficients, powers).zipped map {(a,p) => a * Math.pow(x, p)}).sum
  }

  // This function will be used while invoking "Summation" to compute
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients:List[Int],powers:List[Int],x:Double):Double =
  {
    val y : Double = f(coefficients,powers,x)
    Math.PI * y * y
  }

  // This is the part where the series is summed up
  // This function is invoked once with func = f to compute the area         // under the curve
  // Then it is invoked again with func = area to compute the volume
  // of revolution of the curve
  def summation(func:(List[Int],List[Int],Double)=>Double,upperLimit:Int,lowerLimit:Int,coefficients:List[Int],powers:List[Int]):Double =
  {
    val delta = 0.001
    ((lowerLimit * 1.0 to (upperLimit, delta)) map { x => delta * func(coefficients, powers, x)}).sum
  }


  // The Input-Output functions will be handled by us. You only need to concentrate your effort on the function bodies above.
  def displayAnswers(coefficients:List[Int],powers:List[Int],limits:List[Int])
  {
    println(summation(f,limits.reverse.head,limits.head,coefficients,powers))
    println(summation(area,limits.reverse.head,limits.head,coefficients,powers))
  }

  def main(args: Array[String]) {
    /** Purely IO Section **/
    displayAnswers(readLine().trim().split(" ").toList.map(_.toInt),readLine().trim().split(" ").toList.map(_.toInt),readLine().trim().split(" ").toList.map(_.toInt))
  }
}
