package cn.snowpic.day_8_24;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

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
        System.out.println(task.get());
        System.out.println("return value has been received.." + LocalDateTime.now());
        System.out.println(submit.get());

        //======================
        Thread.sleep(10000);
    }

    /**
     * test4 for reentrant lock
     * @author lf
     * @time 2019/8/24 21:25
     */
    @Test
    public void test4() throws Exception {
        final GenericTest test = new GenericTest();
        new Thread(() -> {
            try {
                test.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                test.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(8000);
    }

    private static ReentrantLock lock = new ReentrantLock();

    private void m1() throws InterruptedException {

        try {
            lock.lock();
            System.out.println("method 1 lock");
            lock.lock();
            System.out.println("method 1 lock");
            lock.lock();
            System.out.println("method 1 lock");
            System.out.println("enter method 1....");
            long time = (long) (Math.random() * 6000);
            System.out.println("time = " + time);
            Thread.sleep(time);
            System.out.println("exit method 1....");
        } finally {
            lock.unlock();
        }
    }

    private void m2() throws InterruptedException {

        try {
            lock.lock();
            System.out.println("enter method 2....");
            long time = (long) (Math.random() * 3000);
            System.out.println("time = " + time);
            Thread.sleep(time);
            System.out.println("exit method 2....");
        } finally {
            lock.unlock();
        }
    }

    /**
     * test5 for usage of disruptor
     * @author lf
     * @time 2019/8/24 23:25
     */
    @Test
    public void test5() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Disruptor<LongEvent> disruptor = new Disruptor<>(new LongEventFactory(), 1024 * 1024, pool, ProducerType.SINGLE, new YieldingWaitStrategy());

        disruptor.handleEventsWith(new LongEventHandler());

        // start disruptor
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProvider provider = new LongEventProvider(ringBuffer);

        for (long i = 0; i < 100; i++) {
            provider.putData(i);
        }

        disruptor.shutdown();
        pool.shutdown();

        Thread.sleep(3000);
    }
}

/**
 * long event
 * @className LongEvent
 * @author lf
 * @time 2019/8/24 23:31
 */
class LongEvent {
    private long value;

    long getValue() {
        return value;
    }

    void setValue(long value) {
        this.value = value;
    }
}

/**
 * long event factory
 * @className LongEventFactory
 * @author lf
 * @time 2019/8/24 23:31
 */
class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}

/**
 * long event handler
 * @className LongEventHandler
 * @author lf
 * @time 2019/8/24 23:30
 */
class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}

/**
 * long event provider
 * @className LongEventProvider
 * @author lf
 * @time 2019/8/24 23:43
 */
class LongEventProvider {
    private RingBuffer<LongEvent> ringBuffer;

    LongEventProvider(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    void putData(long value) {
        long next = ringBuffer.next();
        try {
            LongEvent event = ringBuffer.get(next);
            event.setValue(value);
        } finally {
            ringBuffer.publish(next);
        }
    }
}