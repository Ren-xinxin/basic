/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */
package cn.snowpic.year_2019.month_10.day_15;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lf
 * @className GenericTest
 * @description
 * @time 2019/10/15 20:36
 */

public class GenericTest {
    private CuratorFramework cf;

    @Before
    public void init() {
        cf = CuratorFrameworkFactory.builder()
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .connectString("192.168.20.121:2181,192.168.20.122:2181,192.168.20.123:2181")
                .connectionTimeoutMs(10000)
                .build();

        // start client
        cf.start();
    }

    @After
    public void release() {
        cf.close();
    }


    private int count = 100;

    /**
     * distributed lock
     *
     * @author lf
     * @time 2019/10/15 20:40
     */
    @Test
    public void test1() throws Exception {
        cf.blockUntilConnected();
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                // final InterProcessMutex lock = new InterProcessMutex(cf, "/rxx");
                final ReentrantLock lock = new ReentrantLock();
                try {
                    // lock.acquire();
                    lock.lock();
                    TimeUnit.SECONDS.sleep(new SecureRandom().nextInt(4));
                    System.out.println(count--);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        // lock.release();
                        lock.unlock();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    /**
     * distributed atomic integer
     * @author lf
     * @time 2019/10/15 21:27
     */
    @Test
    public void test2() throws Exception {
        cf.blockUntilConnected();
        DistributedAtomicInteger count = new DistributedAtomicInteger(cf, "/atomic", new RetryNTimes(3, 1000));
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            pool.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(new SecureRandom().nextInt(5));
                    AtomicValue<Integer> increment = count.increment();
                    // System.out.println("increment.succeeded() = " + increment.succeeded());
                    System.out.println("increment.preValue() = " + increment.preValue());
                    System.out.println("increment.postValue() = " + increment.postValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }


        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
