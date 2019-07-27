package com.dccsh.net.group.one.workplan.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.dccsh.net.group.one.workplan.config.prop.MongoClusterProperties;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MultipleMongoConfig {
    // @Autowired
    // private MultipleMongoProperties mongoProperties;

    @Autowired
    private MongoClusterProperties mongoClusterProperties;

    @Primary
    @Bean(name = MongoWorkPlanConfig.MONGO_TEMPLATE)
    public MongoTemplate workPlanMongoTemplate() throws Exception {
        // return new
        // MongoTemplate(netcoolFactory(this.mongoProperties.getNetcool()));
        return new MongoTemplate(workPlanFactory(mongoClusterProperties.getMongoServerList(),
                mongoClusterProperties.getWorkPlan().createMongoCredential()));
    }

    // @Bean
    // @Primary
    // public MongoDbFactory netcoolFactory(MongoProperties mongo) throws
    // Exception {
    // System.out.println(mongoClusterProperties.getIntegratedInfo().getDatabase());
    // MongoClient mongoClient;
    // MongoCredential credential =
    // MongoCredential.createCredential(mongo.getUsername(),
    // mongo.getDatabase(),
    // mongo.getPassword());
    // mongoClient = new MongoClient(new ServerAddress(mongo.getHost(),
    // mongo.getPort()), Arrays.asList(credential));
    // return new SimpleMongoDbFactory(mongoClient, mongo.getDatabase());
    // }
    //
    // @Bean
    // public MongoDbFactory integratedInfoFactory(MongoProperties mongo) throws
    // Exception {
    // MongoClient mongoClient;
    // MongoCredential credential =
    // MongoCredential.createCredential(mongo.getUsername(),
    // mongo.getDatabase(),
    // mongo.getPassword());
    // mongoClient = new MongoClient(new ServerAddress(mongo.getHost(),
    // mongo.getPort()), Arrays.asList(credential));
    // return new SimpleMongoDbFactory(mongoClient, mongo.getDatabase());
    // }

    @Bean
    @Primary
    public MongoDbFactory workPlanFactory(List<ServerAddress> servers, MongoCredential credential)
            throws Exception {
        return getFactory(servers, credential);
    }

    private MongoDbFactory getFactory(List<ServerAddress> servers, MongoCredential credential) throws Exception {
        MongoClient mongoClient;
        mongoClient = new MongoClient(servers, Arrays.asList(credential));
        return new SimpleMongoDbFactory(mongoClient, credential.getSource());
    }
}
