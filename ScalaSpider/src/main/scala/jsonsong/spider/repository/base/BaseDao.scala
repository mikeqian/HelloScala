package jsonsong.spider.repository.base

import com.alibaba.fastjson.JSON
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.commons.ValidBSONType.DBObject
import jsonsong.spider.common.GlobalHelper._
import com.mongodb.casbah.MongoCollection

/**
  * Created by jsons on 2015/12/28.
  */
class BaseDao[T](cn: MongoCollection) {
  def insert(entity: T): Object = {
    val dbo = MongoDBObject(entity.toPojoMap().toList)
    cn.insert(dbo).getUpsertedId
  }

  def getCn: MongoCollection =   cn

}




