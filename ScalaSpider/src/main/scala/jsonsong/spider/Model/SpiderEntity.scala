package jsonsong.spider.Model

import java.util.Date

import jsonsong.spider.repository.base.BaseEntity

/**
  * Created by jsons on 2015/12/28.
  */

 class SpiderEntity(var Title: String, var Content: String,var Url: String) extends BaseEntity  {
  var Weight: Short = 0
  var Name: String = ""
  var AddedTime: Date = new Date()
}

//object SpiderEntity {
//  def apply(): SpiderEntity = {
//    new SpiderEntity() {
//      Title = title
//      Content = content
//      Url = url
//    }
//  }
//}

//object SpiderEntityProperties {
//  val Title = "Title"
//  val Content = "Content"
//  val Url = "Url"
//  val Weight = "Weight"
//  val AddedTime = "AddedTime"
//}