package cn.snowpic.year_2019.month_07.day_25;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/7/25 21:26
 **/

public class GenericTest {

    @Test
    public void test1() throws InterruptedException {
        Runnable runnable = () -> System.out.println("good boy is me ....");
        Executors.newCachedThreadPool().execute(runnable);

        Thread.sleep(3000);
    }

    @Test
    public void test2() {
        m1("some message....");
    }

    private static void m1(String msg) {
        Assert.assertNotNull("params must not be null !", msg);
        System.out.println(msg);
    }

    @Test
    public void test3() {
        double price = 1.0 - 0.1;
        System.out.println(price);
        System.out.println("price = " + price);
    }

    @Test
    public void test4() {
        System.out.println("Intellij IDEA ultimate.....");
        System.out.println("I am confused about something..");
        System.out.println("I have got a job in isoftstone,but I am actually unhappy.I don't know why...");

    }
}
