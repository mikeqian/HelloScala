package jsonsong.spider.job;

import jsonsong.spider.common.CommonUtils;
import jsonsong.spider.common.Constants;
import jsonsong.spider.processor.AutoHomePageProcessor;
import jsonsong.spider.pipeline.MyMongoPipeline;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.Date;

@Component
public class CarJob implements Job {
    private static Logger log = LoggerFactory.getLogger(CarJob.class);

    @Autowired
    private MyMongoPipeline pipeline;

    @Autowired
    private AutoHomePageProcessor processor;

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        log.info("Start Car Job");

        String startUrl = String.format(Constants.AUTO_HOME_SEED, 1);

        Spider.create(processor).addUrl(startUrl).addPipeline(pipeline).run();

        log.info("finish Car Job at: " + CommonUtils.getTimeSimpleText(new Date()));
    }
}