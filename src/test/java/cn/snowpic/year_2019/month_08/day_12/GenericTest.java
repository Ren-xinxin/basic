package cn.snowpic.year_2019.month_08.month_08.day_12;

import org.junit.Test;

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
