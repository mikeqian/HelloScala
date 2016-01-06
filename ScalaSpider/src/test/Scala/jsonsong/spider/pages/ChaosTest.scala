import java.util.regex.{Matcher, Pattern}


import jsonsong.spider.pages.ChaosProcessor
import org.junit.Test
import us.codecraft.webmagic.selector.Html

class ChaosTest {


  @Test def Test1 {
    val url = "http://262vv.com/html/se/126389.html"

    val reg = "262vv.com/html/se/126389.html"

    val html = new Html("<div class=\"title\">\n" + " 不亦乐乎【18P】\n" + "</div>")

    //val spider = ChaosProcessor.main(str)


    //assert(  url.matches(ChaosProcessor.contentReg)   )
    //  assert(url.matches(reg))
  }
}