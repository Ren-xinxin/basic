package cn.snowpic.year_2019.day_08_25;

import com.lmax.disruptor.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/25 18:15
 **/

@SuppressWarnings("ALL")
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/8/25 18:36
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {

        RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(Trade::new, 1024 * 1024);

        ExecutorService pool = Executors.newFixedThreadPool(4);

        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        BatchEventProcessor<Trade> processor = new BatchEventProcessor<>(ringBuffer, sequenceBarrier, (trade, l, b) -> System.out.println(trade.getNo() + ":" + trade.getValue()));

        ringBuffer.addGatingSequences(processor.getSequence());

        pool.submit(processor);

        Future<?> submit = pool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                long next = ringBuffer.next();
                Trade trade = ringBuffer.get(next);
                trade.setNo(i);
                trade.setValue("you are the poison...");
                ringBuffer.publish(next);
            }
        });

        //blocking util the thread exit
        submit.get();

        //shutdown processor
        processor.halt();

        //shutdown thread pool
        pool.shutdown();

        Thread.sleep(3000);
    }

    static class Trade {
        int no;
        String value;

        int getNo() {
            return no;
        }

        void setNo(int no) {
            this.no = no;
        }

        String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }
    }
}
