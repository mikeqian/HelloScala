package jsonsong.spider.common

import com.alibaba.fastjson.JSON
import jsonsong.spider.common.GlobalHelper._
import com.alibaba.fastjson.serializer.SerializerFeature
import com.mongodb.casbah.{MongoClientURI, MongoClient}

import com.typesafe.config.{Config, ConfigFactory}
import jsonsong.spider.Model.SpiderEntity
import jsonsong.spider.dao.base.DBFactory
import org.junit.Test

import scala.reflect.ClassTag

class BaseDaoTest {
  @Test def Test1 {

    val dao = DBFactory.getSpiderDao()

    val spider = new  SpiderEntity("1", "2", "3")

    val map2 = spider.toPojoMap()

   // val re = dao.insert(spider)

    println()
  }
}