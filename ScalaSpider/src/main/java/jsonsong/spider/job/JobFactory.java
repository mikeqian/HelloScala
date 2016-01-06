package jsonsong.spider.job;

import jsonsong.spider.common.ConfigHelper;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jsons on 2015/12/31.
 */
@Service
public class JobFactory {

    private static String cronConfig   =    ConfigHelper.getProperty("quartz.spider.cron","0 0 */1 * * ? * ");

    public static void main() {

        //通过schedulerFactory获取一个调度器
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
//		通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();

//		 创建jobDetail实例，绑定Job实现类
//		 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(SpiderJob.class).withIdentity("jsonsong", "spider").build();

//		 定义调度触发规则

//		使用simpleTrigger规则
//		  Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
//				          .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8))
//				          .startNow().build();
//		使用cornTrigger规则
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronConfig))
                    .startNow().build();

//		 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);

//		 启动调度
            scheduler.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}