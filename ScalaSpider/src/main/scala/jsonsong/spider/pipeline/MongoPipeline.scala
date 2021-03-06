package jsonsong.spider.pipeline

import jsonsong.spider.Model.SpiderEntity
import jsonsong.spider.repository.base.DBFactory
import jsonsong.spider.util.ConfigConstant
import us.codecraft.webmagic.pipeline.Pipeline
import us.codecraft.webmagic.{ResultItems, Task}

/**
  * Created by jsons on 2015/12/31.
  */
class MongoPipeline extends Pipeline {
  val dao = DBFactory.getSpiderDao()
  override def process(resultItems: ResultItems, task: Task): Unit = {
    val node = resultItems.get[SpiderEntity](ConfigConstant.SpiderKey)
    if (node == null) {
      return
    }
    dao.insert(node)
  }
}
