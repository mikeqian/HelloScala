package jsonsong.spider.dao.bse

import com.mongodb.casbah.commons.MongoDBObject
import jsonsong.spider.Model.SpiderEntity
import jsonsong.spider.dao.base.{DBFactory, BaseDao}
import jsonsong.spider.common.GlobalHelper._

/**
  * Created by jsons on 2015/12/28.
  */
object SpiderDao {
  val dao = DBFactory.getSpiderDao()
  val cn = dao.getCn

  def exist(url: String): Boolean = {
    val en = cn.findOne( MongoDBObject( "Url" -> url) )
    en.nonEmpty
  }
  def insert(entity: SpiderEntity): Object =  {
    if (entity.Content.isEmpty || entity.Url.isEmpty ){
      return ""
    }
    if (exist(entity.Url)) return ""
    dao.insert(entity)
  }
}
