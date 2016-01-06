package jsonsong.spider.job;

import jsonsong.spider.pages.ChaosProcessor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;

import java.util.Date;

/**
 * Created by jsons on 2016/1/5.
 */
public class SpiderJob implements Job {
  static   Logger log = LoggerFactory.getLogger("spider");

    //把要执行的操作，写在execute方法中
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        log.info("start spider job");
        Spider spider = ChaosProcessor.createSpider();
        spider.start();
    }
}
