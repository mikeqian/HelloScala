package jsonsong.spider.common


/**
  * Created by jsons on 2015/12/30.
  */
object GlobalHelper {

  implicit final class JsonImplicit(private val self: Any) extends AnyVal {
//    @inline def toJson(): String = ""

    @inline def toPojoMap(): Map[String, Any] = {
      val fs = self.getClass.getDeclaredFields
      fs.foreach(_.setAccessible(true))
      fs.map(a => a.getName -> a.get(self)) // all field names
        .toMap
    }
  }
}
