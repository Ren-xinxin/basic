package cn.snowpic.day_8_12;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/12 21:15
 **/

public class GenericTest {
    private volatile int count = 10;

    @Test
    public void test1() throws InterruptedException {
        new Thread(() -> {
            System.out.println("some time just like you .....");
        }).start();

        Thread.sleep(1000);
    }
}