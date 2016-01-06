package jsonsong.spider.dao.base

import com.mongodb.DBObject
import org.bson.types.ObjectId

/**
  * Created by jsons on 2015/12/28.
  */
case class BaseEntity() {
  var _id = new ObjectId
}

trait Function1[-T, +U] {
  def apply(x: T): U
}

