package jsonsong.spider.PageProcessor;

import jsonsong.spider.samples.GithubRepo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


public class AutoHomePageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(0);


    /*
    http://dealer.autohome.com.cn/frame/spec/18892/310000/310100/0/10/2/10?isPage=1&seriesId=526&isAlading=False
     */
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+)").all());

        GithubRepo githubRepo = new GithubRepo();
//        githubRepo.setAuthor(page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        githubRepo.setName(page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        githubRepo.setReadme(page.getHtml().xpath("//div[@id='readme']/tidyText()").toString());
//        if (githubRepo.getName() == null) {
//            //skip this page
//            page.setSkip(true);
//        } else {
//            page.putField("repo", githubRepo);
//        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
