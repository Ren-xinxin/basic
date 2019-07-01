package cn.snowpic.day_7_1;

import org.junit.Test;

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
}

class A {
    public static int i = 1;
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