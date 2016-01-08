package jsonsong.spider.common

import jsonsong.spider.Model.SpiderEntity
import jsonsong.spider.common.GlobalHelper._
import jsonsong.spider.repository.base.DBFactory
import org.junit.Test

class BaseDaoTest {
  @Test def Test1 {

    val dao = DBFactory.getSpiderDao()

    val spider = new  SpiderEntity("1", "2", "3")

    val map2 = spider.toPojoMap()

   // val re = dao.insert(spider)

    println()
  }
}