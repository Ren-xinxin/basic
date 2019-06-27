package cn.snowpic.day_6_21;

import org.junit.Test;

/**
 * @className GenericTest
 * @description //TODO
 * @author lf
 * @time 2019/6/21 9:21
 **/

public class GenericTest {
    public static class A extends B {
    }

    class C extends A {

    }

    @Test
    public void test1() throws InterruptedException {
        A a = new A();
        final int c;
        c = 1;//variable c can be initialized only once

        Thread thread = new Thread(() -> System.out.println("HHHHHHSDSS"));
        thread.start();

        new Thread(() -> System.out.println("i LOVE YOU.....")).start();

        Thread.sleep(2000);
    }


    @Test
    public void test2() {
        int i = 'a' / 3;
        System.out.println(i);
    }

    @Test
    public void test3() {
        System.out.println("What a wonderful day today!");
        System.out.println("今天也是元气满满的一天哟！");
    }
}

class B {

}
