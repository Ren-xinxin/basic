package cn.snowpic.day_7_25;

import com.sun.istack.internal.NotNull;
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
    public void test2(){
        m1("some message....");
    }

    private static void m1(@NotNull String msg){
        Assert.assertNotNull("params must not be null !",msg);
        System.out.println(msg);
    }
}
