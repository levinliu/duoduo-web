package org.duoduochild.magic.duoduo.web.configuration;

import com.mongodb.*;
import org.duoduochild.magic.duoduo.web.configuration.properties.MongoDbProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levinliu on 2017/10/18
 * GitHub: https://github.com/levinliu
 * (Change file header on Settings -> Editor -> File and Code Templates)
 */
@Configuration
@ComponentScan({"org.duoduochild.magic.duoduo.web"})
@EnableMongoRepositories(basePackages = "org.duoduochild.magic.duoduo.web.data.mongodb")
public class MongoDbConfiguration {
    @Autowired
    private MongoDbProperties mongoDbProperties;

    private MongoClientOptions setupClientOptions(MongoDbProperties.PoolOptions poolOptions) {
        MongoClientOptions.Builder options = new MongoClientOptions.Builder();
        options.connectionsPerHost(poolOptions.getConnectionsPerHost());
        options.connectTimeout(poolOptions.getConnectionsPerHost());
        options.maxWaitTime(poolOptions.getMaxWaitTime());
        options.socketTimeout(poolOptions.getSocketTimeout());
        options.threadsAllowedToBlockForConnectionMultiplier(poolOptions.getThreadsAllowedToBlockForConnectionMultiplier());
        options.writeConcern(poolOptions.getWriteConcern());
        return options.build();
    }

    @Bean("mongoDbFactory")
    public MongoDbFactory mongoDbFactory() {
        Assert.notNull(mongoDbProperties);
        ServerAddress serverAddress = new ServerAddress(mongoDbProperties.getHost(), mongoDbProperties.getPort());
        List<ServerAddress> addresses = new ArrayList<>();
        addresses.add(serverAddress);
        Assert.notNull(mongoDbProperties.getPassword());
        MongoCredential credential = MongoCredential.createScramSha1Credential(mongoDbProperties.getLogin(), mongoDbProperties.getAdminDb(), mongoDbProperties.getPassword().toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);
        return new SimpleMongoDbFactory(new MongoClient(mongoDbProperties.getHost(), setupClientOptions(mongoDbProperties.getPoolOptions())), mongoDbProperties.getDatabase());
    }

    @Bean
    public MongoTemplate mongoTemplate(@Qualifier("mongoDbFactory")MongoDbFactory factory){
        return new MongoTemplate(factory);
    }
}
