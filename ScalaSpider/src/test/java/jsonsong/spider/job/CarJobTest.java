package jsonsong.spider.job;

import org.junit.Test;
import org.quartz.JobExecutionException;

public class CarJobTest {
    @Test
    public void spiderTest() throws JobExecutionException {
        new CarJob().execute(null);
    }
}
