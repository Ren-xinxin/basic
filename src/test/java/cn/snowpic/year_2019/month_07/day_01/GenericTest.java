package cn.snowpic.year_2019.month_07.day_01;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className GenericTest
 * @description generic test
 * @author lf
 * @time 2019/7/1 10:14
 **/

public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/7/1 10:35
     */
    @Test
    public void test1() {
        String ll = "I love programing ......";
        System.out.println(ll);
    }

    /**
     * test2 interface default implement
     * @author lf
     * @time 2019/7/1 10:22
     */
    @Test
    public void test2() {
        new B().m1();
    }


    @Test
    public void test3() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println("overlord......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("nothing to do....");
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am god of the world......");
            }
        });

        Thread.sleep(3000);
    }
}

class A {
    public static int IIIII = 1;
}

class B extends C implements D {
    /**
     * m1
     * @author lf
     * @time 2019/7/1 11:01
     */
    @Override
    public void m1() {

    }
}

abstract class C {
    abstract void m1();
}

interface D {
    default void m1() {
        System.out.println("default implement method....");
    }
}