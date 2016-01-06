

package jsonsong.spider;

import jsonsong.spider.job.JobFactory;
import jsonsong.spider.job.SpiderJob;
import org.quartz.JobExecutionContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class MyBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyBootApplication.class, args);
		//JobFactory.main();
		SpiderJob job = new SpiderJob();
		JobExecutionContext arg = null;
		job.execute(arg);
	}
}
