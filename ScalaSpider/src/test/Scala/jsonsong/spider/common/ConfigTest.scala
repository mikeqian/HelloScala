package jsonsong.spider.common

import com.mongodb.MongoClientURI
import com.typesafe.config.{Config, ConfigFactory}
import org.junit.Test
import org.springframework.data.mongodb.core.SimpleMongoDbFactory

class ConfigTest {
  @Test def Test1 {
    val uriStr: String = ConfigHelper.getProperty("database.uri", "")
    val db = new SimpleMongoDbFactory(new MongoClientURI(uriStr))



    val str = "" ;

  }
}