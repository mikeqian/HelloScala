package jsonsong.spider.job;

import jsonsong.spider.samples.GithubRepoPageProcessor;
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

        Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").thread(5).run();
    }
}