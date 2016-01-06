package jsonsong.spider.pages

import javax.management.JMException
import jsonsong.spider.Model.SpiderEntity
import jsonsong.spider.common.ConfigHelper
import jsonsong.spider.pipeline.MongoPipeline
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import us.codecraft.webmagic.handler.RequestMatcher.MatchOther

import scala.collection.JavaConverters._
import jsonsong.spider.util.ConfigConstant
import us.codecraft.webmagic.handler.{SubPageProcessor, CompositePageProcessor}
import us.codecraft.webmagic.monitor.SpiderMonitor
import us.codecraft.webmagic.pipeline.{FilePipeline, ConsolePipeline}
import us.codecraft.webmagic.scheduler.{FileCacheQueueScheduler, QueueScheduler}
import us.codecraft.webmagic.scheduler.component.BloomFilterDuplicateRemover
import us.codecraft.webmagic.{Request, Page, Spider, Site}

/**
  * Created by jsons on 2015/12/28.
  */

//home index
case class HomeSub() extends SubPageProcessor {
  override def `match`(request: Request): Boolean = {
    request.getUrl.matches(ChaosProcessor.homeReg)
  }

  override def processPage(page: Page): MatchOther = {
    //get all index url
    val indexLinks = page.getHtml.links().regex(ChaosProcessor.indexReg).all().asScala.distinct.asJava
    page.addTargetRequests(indexLinks)
    MatchOther.NO
  }
}

case class IndexSub() extends SubPageProcessor {
  override def `match`(request: Request): Boolean = {
    request.getUrl.matches(ChaosProcessor.indexReg)
  }

  override def processPage(page: Page): MatchOther = {
    val contentLinks = page.getHtml.links().regex(ChaosProcessor.contentReg).all()
    page.addTargetRequests(contentLinks)
    MatchOther.NO
  }
}

case class ContentSub() extends SubPageProcessor {

  override def `match`(request: Request): Boolean = {
    request.getUrl.matches(ChaosProcessor.contentReg)
  }

  override def processPage(page: Page): MatchOther = {
    var content = page.getHtml.$(".content .n_bd ").toString
    content = content.replace("src=\"/js/ads/22.js\"", "")

    if (ChaosProcessor.isInit){
      val nextPage = page.getHtml.$(".pagea").links().regex(ChaosProcessor.contentReg).all()
      page.addTargetRequests(nextPage)
    }

    val node: SpiderEntity = new SpiderEntity(
      Title = page.getHtml.getDocument.select(".main .title ").text(),
      Content = content,
      Url = page.getRequest.getUrl
    )
    node.Name = "Chaos"
    page.putField(ConfigConstant.SpiderKey, node)
    MatchOther.NO
  }
}

class ChaosProcessor() extends CompositePageProcessor(ChaosProcessor.site) {
  this.setSubPageProcessors(new HomeSub, new IndexSub, new ContentSub)
}

object ChaosProcessor {
  val homeReg = "^http://262vv.com"
  val indexReg = "^http://262vv.com/html/part/index\\d{2}.html"
  val contentReg = "^http://262vv\\.com/html/se/\\d{5,6}.html"
  val site: Site = Site.me.setDomain("262vv.com").setUserAgent(ConfigConstant.UserAgent)

  val isInit = ConfigHelper.getProperty("spider.isinit",false)
  def createSpider: Spider = {

    Spider.create(new ChaosProcessor())
      .setScheduler(new FileCacheQueueScheduler(ConfigConstant.SpiderFileCacheKey))
      .addUrl("http://262vv.com")
      // .addUrl("http://262vv.com/html/part/index26.html")
      //.addUrl("http://262vv.com/html/se/126389.html")
      .addPipeline(new ConsolePipeline)
     // .addPipeline(new FilePipeline)
      .addPipeline(new MongoPipeline)
  }

  def main(args: Array[String]) {
    val spider: Spider = ChaosProcessor.createSpider
    SpiderMonitor.instance.register(spider)
    spider.run
  }
}
