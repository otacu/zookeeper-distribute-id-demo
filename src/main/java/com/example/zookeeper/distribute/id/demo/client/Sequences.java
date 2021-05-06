package com.example.zookeeper.distribute.id.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sequences {

    @Autowired
    private ZookeeperClient client;

    public Long sequence(String project, String module, String table) {
        StringBuilder nameSb = new StringBuilder();
        nameSb.append(project).append("/").append(module).append("/").append(table).append("/id");
        return this.client.sequence(nameSb.toString());
    }

}