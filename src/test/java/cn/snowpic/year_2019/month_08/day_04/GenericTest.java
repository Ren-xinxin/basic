package cn.snowpic.year_2019.month_08.day_04;

import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/4 12:24
 **/

public class GenericTest {

    /**
     * timed task with Timer class
     * @author lf
     * @time 2019/8/4 12:25
     */
    @Test
    public void test1() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer is running....");

            }
        }, 1000);

        Thread.sleep(3000);
    }

    /**
     * timed task with Timer class
     * @author lf
     * @time 2019/8/4 12:25
     */
    @Test
    public void test2() throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        service.scheduleAtFixedRate(() -> {
            System.out.println(new Date().toLocaleString());
        }, 1, 1, TimeUnit.SECONDS);

        // main thread remains 10 seconds
        Thread.sleep(1000 * 10);
    }
}
