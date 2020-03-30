/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_30;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericTest {

    private static final char ORIGIN = 'a';

    private AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.submit(() -> {
            while (counter.get() < 26) {
                synchronized (this) {
                    try {
                        wait();
                        print();
                        notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        pool.submit(() -> {
            while (counter.get() < 26) {
                synchronized (this) {
                    try {
                        notify();
                        wait();
                        print();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * print
     *
     * @author Little Flower
     * @date 2020-03-30 20:58:06
     */
    private void print() {
        char str = (char) (ORIGIN + counter.getAndIncrement());
        System.out.println(Thread.currentThread().getName() + ":" + str);
    }
}
