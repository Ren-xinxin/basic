package cn.snowpic.day_8_18;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @className GnericTest
 * @description
 * @author lf
 * @time 2019/8/18 21:30
 **/

public class GenericTest {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new Task());
        String s = submit.get();
        System.out.println(s);
    }
}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "You are so handsome that I am fall in love with you ....";
    }

    public Task() {
    }
}
