package jsonsong.spider.repository.base


import com.mongodb.casbah.{MongoCollection, MongoDB, MongoClientURI, MongoClient}
import com.typesafe.config.ConfigFactory
import jsonsong.spider.Model.SpiderEntity
import jsonsong.spider.common.ConfigHelper


/**
  * Created by jsons on 2015/12/28.
  */
object DBFactory {

  val uri = ConfigHelper.getProperty("database.uri","")
  //val username = config.getString("database.username")

  val mongo = MongoClient(MongoClientURI(uri))
  val db = getDB()


  def getDB(dbName: String = ""): MongoDB = dbName match {
    case dbName.isEmpty => mongo("jsonsong")
    case _ => mongo(dbName)
  }

  def getCollection(cnName: String, db: MongoDB = db): MongoCollection = {
    db(cnName)
  }


  def getSpiderDao(  ): BaseDao[SpiderEntity] = {
    val cn = getCollection("SpiderEntity")
    new BaseDao[SpiderEntity](cn)
  }
}
