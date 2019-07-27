package com.dccsh.net.group.one.workplan.config.prop;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {
	private MongoProperties workPlan = new MongoProperties();

	public MongoProperties getWorkPlan() {
		return workPlan;
	}

	public void setWorkPlan(MongoProperties workPlan) {
		this.workPlan = workPlan;
	}

}
