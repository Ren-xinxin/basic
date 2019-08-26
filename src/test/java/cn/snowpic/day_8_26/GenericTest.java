package cn.snowpic.day_8_26;

import com.lmax.disruptor.*;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/26 22:36
 **/

public class GenericTest {

    /**
     * test1 for multi producer and customer
     * @author lf
     * @time 2019/8/26 22:36
     */
    @Test
    public void test1() throws InterruptedException {

        // get ring buffer
        RingBuffer<Order> ringBuffer = RingBuffer.createMultiProducer(Order::new, 1024 * 1024, new YieldingWaitStrategy());

        // get barrier
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        //count
        AtomicInteger ai1 = new AtomicInteger();
        AtomicInteger ai2 = new AtomicInteger();
        AtomicInteger ai3 = new AtomicInteger();

        //wh1
        WorkHandler<Order> workHandler1 = order -> {
            System.out.println("current customer is a,order value" + order.getValue());
            ai1.getAndIncrement();
        };

        //wh2
        WorkHandler<Order> workHandler2 = order -> {
            System.out.println("current customer is b,order value" + order.getValue());
            ai2.getAndIncrement();
        };

        //wh3
        WorkHandler<Order> workHandler3 = order -> {
            System.out.println("current customer is c,order value" + order.getValue());
            ai3.getAndIncrement();
        };

        // create a work pool
        WorkerPool<Order> workerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new ExceptionHandler<Order>() {
            @Override
            public void handleEventException(Throwable throwable, long l, Order order) {

            }

            @Override
            public void handleOnStartException(Throwable throwable) {

            }

            @Override
            public void handleOnShutdownException(Throwable throwable) {

            }
        }, workHandler1, workHandler2, workHandler3);

        //add gate sequence
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());

        // start work pool
        workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

        // count down latch
        final CountDownLatch latch = new CountDownLatch(1);

        // count
        AtomicInteger at4 = new AtomicInteger();

        //crate 100 threads to crate product
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 100; j++) {
                    long next = ringBuffer.next();
                    try {
                        ringBuffer.get(next)
                                .setValue(UUID.randomUUID().toString());
                    } finally {
                        ringBuffer.publish(next);
                    }
                    at4.getAndIncrement();
                }
            }).start();
        }

        Thread.sleep(2000);

        System.out.println("开始生产数据------------------");
        // start produce
        latch.countDown();

        Thread.sleep(5000);
        //print something
        System.out.println("ai4 = " + at4);
        System.out.println("ai1 = " + ai1);
        System.out.println("ai2 = " + ai2);
        System.out.println("ai3 = " + ai3);
        Thread.sleep(1000);
    }
}

class Order {

    int id;

    String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
