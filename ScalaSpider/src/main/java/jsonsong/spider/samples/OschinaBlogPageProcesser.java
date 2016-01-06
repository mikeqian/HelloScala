package jsonsong.spider.samples;

import jsonsong.spider.util.ConfigConstant;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.handler.SubPageProcessor;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.BloomFilterDuplicateRemover;


import javax.management.JMException;
import java.util.List;

/**
 * @author code4crafter@gmail.com <br>
 */
public class OschinaBlogPageProcesser implements PageProcessor {

    private Site site = Site.me().setDomain("my.oschina.net").setUserAgent(ConfigConstant.UserAgent);

    @Override
    public void process(Page page) {

        List<String> links = page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1/text()").toString());
        page.putField("content", page.getHtml().xpath("//div[@class='BlogContent']/tidyText()").toString());
        page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws JMException {
        Spider spider = Spider.create(new OschinaBlogPageProcesser())
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(2000)))
                .addUrl("http://my.oschina.net/flashsword/blog");
        //spider.addUrl("http://my.oschina.net/flashsword/blog");
        SpiderMonitor.instance().register(spider);

        spider.run();
    }
}
