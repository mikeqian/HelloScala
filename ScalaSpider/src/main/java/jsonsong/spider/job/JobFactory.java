package jsonsong.spider.job;

import jsonsong.spider.common.ConfigHelper;
import jsonsong.spider.common.Constants;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobFactory {
    private static Logger log = LoggerFactory.getLogger(JobFactory.class);
    private static String cronConfig = ConfigHelper.getProperty("quartz.spider.cron", "0 0 */1 * * ? * ");

    @Autowired
    private CarJob carJob;


    public void doJob() {
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler;
        try {
            scheduler = schedulerfactory.getScheduler();

            JobDetail job = JobBuilder.newJob(SpiderJob.class).withIdentity("jsonsong", "spider").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronConfig))
                    .startNow().build();
            scheduler.scheduleJob(job, trigger);

            scheduler.start();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}