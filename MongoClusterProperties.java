package com.dccsh.net.group.one.workplan.config.prop;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ServerAddress;

@Configuration
@ConfigurationProperties(prefix = "mongodbCuster")
public class MongoClusterProperties {
	private List<MyServerAddress> servers;
	private MyMongoCredential workPlan;

	public List<MyServerAddress> getServers() {
		return servers;
	}

	public void setServers(List<MyServerAddress> servers) {
		this.servers = servers;
	}

	public MyMongoCredential getWorkPlan() {
		return workPlan;
	}

	public void setWorkPlan(MyMongoCredential workPlan) {
		this.workPlan = workPlan;
	}

	public List<ServerAddress> getMongoServerList() {
		List<ServerAddress> list = servers.stream().map(myServer -> {
			ServerAddress serverAdd = null;
			try {
				serverAdd = new ServerAddress(myServer.getHost(), myServer.getPort());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return serverAdd;
		}).collect(Collectors.toList());
		return list;
	}

}
