package com.dccsh.net.group.one.workplan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.dccsh.net.group.one.workplan.dao", mongoTemplateRef = MongoWorkPlanConfig.MONGO_TEMPLATE)
public class MongoWorkPlanConfig {
    protected static final String MONGO_TEMPLATE = "WorkPlanMongoTemplate";
}
