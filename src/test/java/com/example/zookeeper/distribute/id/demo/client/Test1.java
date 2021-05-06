package com.example.zookeeper.distribute.id.demo.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {
    // 第一步，注入Sequences
    @Autowired
    private Sequences sequences;

    @Test
    public void  test() {
        for (int i = 0; i < 10; i++) {
            System.out.println("生成的自增id为:" + sequences.sequence("project", "module", "table"));
        }
    }
}
