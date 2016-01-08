package jsonsong.spider.job;

import jsonsong.spider.common.Constants;
import jsonsong.spider.pageProcessor.AutoHomePageProcessor;
import jsonsong.spider.pipeline.CarPipeline;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;

public class CarJob implements Job {
    private static Logger log = LoggerFactory.getLogger(CarJob.class);

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        log.info("Start Car Job");

        String startUrl = String.format(Constants.AUTO_HOME_SEED, 1);

        Spider.create(new AutoHomePageProcessor()).addUrl(startUrl).addPipeline(new CarPipeline()).run();
    }
}