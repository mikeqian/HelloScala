package jsonsong.spider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import jsonsong.spider.common.ConfigHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class AppConfig {

    public
    @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        String uriStr = ConfigHelper.getProperty("database.uri", "");
        return new SimpleMongoDbFactory(new MongoClientURI(uriStr));
    }

    public
    @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
