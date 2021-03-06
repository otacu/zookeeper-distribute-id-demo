package com.example.zookeeper.distribute.id.demo.client;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZkSequence {

    RetryPolicy retryPolicy = new ExponentialBackoffRetry(500, 3);

    DistributedAtomicLong distAtomicLong;

    public ZkSequence(String sequenceName, CuratorFramework client) {
        distAtomicLong = new DistributedAtomicLong(client, sequenceName, retryPolicy);
    }

    /**
     * ηζεΊε
     *
     * @return
     * @throws Exception
     */
    public Long sequence() throws Exception {
        AtomicValue<Long> sequence = this.distAtomicLong.increment();
        if (sequence.succeeded()) {
            return sequence.postValue();
        } else {
            return null;
        }
    }

}