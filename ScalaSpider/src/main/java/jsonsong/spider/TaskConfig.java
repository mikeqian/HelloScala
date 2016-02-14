package jsonsong.spider;

import jsonsong.spider.job.CarJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class TaskConfig {

    @Autowired
    private CarJob carJob;

    @Scheduled(cron = "0 0 2 * * ?")
    public void reportCurrentByCron() {
        carJob.execute();
    }
}
