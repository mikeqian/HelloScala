package jsonsong.spider;

import com.mongodb.MongoClient;
import jsonsong.spider.job.CarJob;
import jsonsong.spider.job.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages = "jsonsong.spider")
public class MyBootApplication extends SpringBootServletInitializer {

    @Value("${mongo.host}")
    private String host = "";

    @Value("${mongo.port}")
    private int port = 29000;

    @Autowired
    private MongoDbFactory simpleMongoDbFactory;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyBootApplication.class, args);
        //JobFactory.main();

        new CarJob().execute(null);
    }

}
