package cn.snowpic.year_2019.month_08.month_08.day_11;

import cn.snowpic.util.RxMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/11 12:19
 **/

public class GenericTest {

    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        System.out.println(1 << 31);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test2() {
        RxMap<String, String> map = new RxMap<>();

        map.put("2", "3");
        map.put("4", "3");
        map.put("任新新", "3");
        map.put("悟空", "3");
        System.out.println(map);
    }

    private int count = 5;

    @Test
    public void test3() throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(count);
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(count);
        });
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(count);
        });
        Thread t4 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(count);
        });
        Thread t5 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(count);
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(4000);
    }

    private String userName = "bjsxd";
    private String password = "123456789";

    private synchronized void setValue(String userName, String password) {
        try {
            this.userName = userName;
            System.out.println("user name set successfully,user name is " + this.userName);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("user name set successfully,password is " + this.password);
    }

    private synchronized void getValue() {
        System.out.println("userName = " + userName);
        System.out.println("password = " + password);
    }

    @Test
    public void test4() throws InterruptedException {
        final GenericTest test = new GenericTest();
        new Thread(() -> {
            test.setValue("张三", "123");
        }).start();
        Thread.sleep(100);
        test.getValue();
        Thread.sleep(4000);
    }

    static final class A {

    }

    @Test
    public void test5() {
        System.out.println("wtf");
        System.out.println("something bad...");
    }

    @Test
    public void test6() {
        System.out.println("I love empty....");
        System.out.println("");
    }
}
