package jsonsong.spider.common

import com.typesafe.config.ConfigFactory

/**
  * Created by jsons on 2015/12/30.
  */
object ConfigHelper {
  val config = ConfigFactory.load("application")

  def getProperty[T](string: String, defValue: T ): T = {

    if (defValue.getClass.getSimpleName.equalsIgnoreCase("boolean")) {
      return config.getBoolean(string).asInstanceOf[T]
    }

    val str = config.getString(string)
    if (str.isEmpty) {
      defValue
    } else {
      str.asInstanceOf[T]
    }
  }

}
