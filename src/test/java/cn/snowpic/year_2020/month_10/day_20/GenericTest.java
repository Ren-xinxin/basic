/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_20;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericTest {

    @Test
    public void test1() throws InterruptedException {
        final ExecutorService pool = Executors.newFixedThreadPool(10);
        final ThreadLocal<Integer> local = new ThreadLocal<>();
        final AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                local.set(count.getAndIncrement());
                try {
                    Thread.sleep(2000);
                    System.out.println(local.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(Integer.MAX_VALUE);
    }
}