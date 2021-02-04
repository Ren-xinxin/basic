package cn.snowpic.year_2019.month_10.day_10;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/10/10 22:32
 */

public class GenericTest {
    private int count = 0;

    /**
     * concurrent operate
     * @author lf
     * @time 2019/10/10 22:32
     */
    @Test
    public void test1() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (count < 1000) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println("1===>" + count);
                }
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (count < 1000) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println("2===>" + count);
                }
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (count < 1000) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println("3===>" + count);
                }
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (count < 1000) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println("4===>" + count);
                }
            }
        });

        Thread.sleep(10000);
        System.out.println(count);
    }

    private AtomicInteger countAtomic = new AtomicInteger(0);

    /**
     * atomic class
     * @author lf
     * @time 2019/10/10 22:42
     */
    @Test
    public void test2() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (countAtomic.get() < 1000) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countAtomic.getAndIncrement();
                    System.out.println("1===>" + countAtomic.get());
                }
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (countAtomic.get() < 1000) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countAtomic.getAndIncrement();
                    System.out.println("2===>" + countAtomic.get());
                }
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (countAtomic.get() < 1000) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countAtomic.getAndIncrement();
                    System.out.println("3===>" + countAtomic.get());
                }
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                if (countAtomic.get() < 1000) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countAtomic.getAndIncrement();
                    System.out.println("4===>" + countAtomic.get());
                }
            }
        });

        Thread.sleep(10000);
        System.out.println(countAtomic.get());
    }
}
