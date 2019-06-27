package cn.snowpic.day_6_17;

import org.junit.Assert;
import org.junit.Test;
import sun.security.provider.MD2;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 *@className GenericTest
 *@description //TODO
 *@author lf
 *@date 2019/6/17 8:38
 *@version 1.0.0
 **/

public class GenericTest {

    /**
     * test1
     * @author lf
     * @date 2019/6/17 8:55
     */
    @Test
    public void test1() {
        Singleton.INSTANCE.method1();
    }

    @Test
    public void test2() {
        Map<Object, Object> map = new HashMap<>(10);

        map.put(null, null);
        map.put(null, 22);
        System.out.println(map.size());
        Object o = map.get(null);
        Assert.assertEquals(22, o);
        Map<Object, Object> map1 = new Hashtable<>(10);
        //map1.put(11, null);//can't put null key or value to a hashtable
    }

    @Test
    public void test3() {
        Stack<Object> objects = new Stack<>();
        objects.push(11);
        objects.push(22);
        objects.push(33);
        objects.forEach(System.out::println);
        System.out.println(objects.pop());
    }

    @Test
    public void test4() {
        int i, sum = 0;
        for (i = 0; i < 10; ++i, sum += i) {
            System.out.println(i);
        }
        System.out.println(sum);//55 (1+10)/2*10
    }

    @Test
    public void test5() {
        byte b = (byte) 128;
        long test = 012;
        float a = -412;
    }

    /**
     * dead lock test
     * @author lf
     * @date 2019/6/17 17:43
     */
    @Test
    public void test6() {
        TestLock lock = new TestLock();
        for (int i = 0; i < 1000; i++) {
            new Thread(lock::m1).start();
            new Thread(lock::m2).start();
        }
    }

    @Test
    public void test7() {
        System.out.println("中".getBytes(StandardCharsets.UTF_8).length);
    }

    @Test
    public void test8() {
        TreeMap<Object, Object> map = new TreeMap<>();

        map.put(2, 33);
        map.put(4, 22);
        map.put(5, 11);
        map.put(1, 1);
        map.forEach((k, v) -> System.out.println(v));
        HashMap<Object, Object> hashMap = new HashMap<>();//sorted
        hashMap.put(2, 33);
        hashMap.put(4, 22);
        hashMap.put(5, 11);
        hashMap.put(1, 1);
        hashMap.forEach((k, v) -> System.out.println(v));//unsorted
    }

    /**
     * test9
     * @author lf
     * @date 2019/6/17 19:30
     */
    @Test
    public void test9() {
        System.out.println(new Long(12) == new Long(12));
        System.out.println(new Integer(12) == new Integer(12));
        Long l1 = 12L, l2 = 12L;
        System.out.println(l1 == l2);
        l1 = 199L;
        l2 = 199L;
        //Assert.assertSame(l1, l2);//false
        Integer i1 = 1, i2 = 1;
        //Assert.assertSame(i1, i2);//true
        Byte b1 = 1, b2 = 1;
        Assert.assertSame(b1, b2);//true
    }

    /**
     * char initial value
     * @author lf
     * @date 2019/6/17 19:41
     */
    @Test
    public void test11() {
        System.out.println("========" + (TestLock.ch1 + 1) + "======");//default char value is
        // the same as '0'
        System.out.println((char) 1);
        System.out.println((char) 2);
        System.out.println((char) 3);
        System.out.println((char) 4);
        System.out.println((char) 97);
    }
}

/**
 * singleton
 * @className Singleton
 * @author lf
 * @date 2019/6/17 20:36
 */
enum Singleton {

    INSTANCE;

    public void method1() {
        System.out.println("Do something...");
    }
}

/**
 * t
 * @className T
 * @author lf
 * @date 2019/6/17 20:36
 */
abstract class T {
    final int i;

    public T(int i) {
        this.i = i;//final variable must be initialized when it is assigned or in a constructor
    }

    abstract void method1();
}

/**
 * a
 * @className A
 * @author lf
 * @date 2019/6/17 20:36
 */
interface A {
    default void M1() {
    }

    static int IIIi = 10;
}

/**
 * test lock
 * @className TestLock
 * @author lf
 * @date 2019/6/17 20:36
 */
class TestLock {
    private final Object left = new Object();
    private final Object right = new Object();

    static char ch1;

    public void m1() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void m2() {
        synchronized (right) {
            synchronized (left) {
                doSomething();
            }
        }
    }

    private void doSomething() {
        System.out.println(".........");
    }
}