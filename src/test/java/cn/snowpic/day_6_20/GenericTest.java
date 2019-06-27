package cn.snowpic.day_6_20;

import org.junit.Test;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * generic test
 * @className GenericTest
 * @author lf
 * @time 2019/6/19 14:16
 */

public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/6/20 12:06
     */
    @Test
    public void test1() {

    }

    @Test
    public void test2() {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        //hashtable.put(1, null);//null can't be a key of hashtable
        Executors.newCachedThreadPool().execute(()->{
            System.out.println("..............");
        });
    }
}

/**
 * a
 * @className A
 * @author lf
 * @time 2019/6/20 12:07
 */
class A {

}

/**
 * b
 * @className B
 * @author lf
 * @time 2019/6/20 12:07
 */
class B extends A {

}

/**
 * i c
 * @className IC
 * @author lf
 * @time 2019/6/20 12:07
 */
interface IC {
    A m1() throws IOException;
}

/**
 * c
 * @className C
 * @author lf
 * @time 2019/6/20 12:07
 */
class C implements IC {

    /**
     * m1
     * @author lf
     * @time 2019/6/20 12:07
     * @return B
     */
    @Override
    public B m1() {
        // method can be override with a subclass return value
        return null;
    }
}