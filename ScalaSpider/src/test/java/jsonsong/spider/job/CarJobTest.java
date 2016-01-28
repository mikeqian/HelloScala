package jsonsong.spider.job;

import jsonsong.spider.base.BaseJunit4Test;
import org.junit.Test;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarJobTest extends BaseJunit4Test {

    @Autowired
    private CarJob carJob;

    @Test
    public void spiderTest() throws JobExecutionException {
        //carJob.execute();
    }
}
