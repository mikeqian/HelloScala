package jsonsong.spider.job;

import jsonsong.spider.common.ConfigHelper;
import jsonsong.spider.common.Constants;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JobFactory {
    private static Logger log = LoggerFactory.getLogger(JobFactory.class);
    private static String cronConfig = ConfigHelper.getProperty("quartz.spider.cron", "0 0 */1 * * ? * ");

    public static void main() {

        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler;
        try {
            scheduler = schedulerfactory.getScheduler();

            JobDetail job = JobBuilder.newJob(SpiderJob.class).withIdentity("jsonsong", "spider").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronConfig))
                    .startNow().build();
            scheduler.scheduleJob(job, trigger);

            scheduler.scheduleJob(JobBuilder.newJob(CarJob.class).build(), getCarTrigger());

            scheduler.start();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private static Trigger getCarTrigger() {
        return TriggerBuilder.newTrigger().withIdentity("carTrigger", "carTriggerGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule(Constants.AUTO_HOME_CORN))
                .startNow().build();
    }
}