package cn.snowpic.day_8_24;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/24 15:20
 **/

public class GenericTest {

    /**
     * count down latch....
     * @author lf
     * @time 2019/8/24 15:32
     */
    @Test
    public void test() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("something good is happening...");
        }).start();

        new Thread(() -> {
            Random random = new Random();
            int sleep;
            while ((sleep = random.nextInt(5000)) < 1000) {
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("thread 1 count down...");
        }).start();

        new Thread(() -> {
            Random random = new Random();
            int sleep;
            while ((sleep = random.nextInt(5000)) < 1000) {
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("thread 2 count down...");
        }).start();

        Thread.sleep(10000);
    }

    /**
     * test2 cycleCarrier
     * @author lf
     * @time 2019/8/24 17:57
     */
    @Test
    public void test2() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);

        new Thread(() -> {
            Random random = new Random();
            int sleep;
            while ((sleep = random.nextInt(5000)) < 1000) {
            }
            try {
                Thread.sleep(sleep);
                System.out.println("player 1 is ready...");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("player 1 go...");
        }).start();

        new Thread(() -> {
            Random random = new Random();
            int sleep;
            while ((sleep = random.nextInt(5000)) < 1000) {
            }
            try {
                Thread.sleep(sleep);
                System.out.println("player 2 is ready...");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("player 2 go...");
        }).start();

        new Thread(() -> {
            Random random = new Random();
            int sleep;
            while ((sleep = random.nextInt(5000)) < 1000) {
            }
            try {
                Thread.sleep(sleep);
                System.out.println("player 3 is ready...");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("player 3 go...");
        }).start();

        Thread.sleep(10000);
    }

    /**
     * future with jdk test3
     * @author lf
     * @time 2019/8/24 18:16
     */
    @Test
    public void test3() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        FutureTask<String> task = new FutureTask<>(() -> {
            Thread.sleep(3000);
            return "SB";
        });
        Future<?> submit = executorService.submit(task);
        System.out.println("task has been submitted...." + LocalDateTime.now());
        submit.cancel(true);
        System.out.println(task.get());
        System.out.println("return value has been received.." + LocalDateTime.now());
        System.out.println(submit.get());

        //======================
        Thread.sleep(10000);
    }
}
