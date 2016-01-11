package jsonsong.spider;

import jsonsong.spider.job.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MyBootApplication extends SpringBootServletInitializer {

    private static JobFactory jobFactory;

    @Autowired
    private JobFactory internalJobFactory;

    @PostConstruct
    public void init() {
        MyBootApplication.jobFactory = internalJobFactory;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyBootApplication.class, args);
        jobFactory.doJob();
    }
}
