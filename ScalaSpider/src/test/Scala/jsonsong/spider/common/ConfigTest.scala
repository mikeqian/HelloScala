package jsonsong.spider.common

import com.typesafe.config.{Config, ConfigFactory}
import org.junit.Test

class ConfigTest {
  @Test def Test1 {


    val uri = ConfigHelper.getProperty("database.uri","")

    val str = uri ;

  }
}