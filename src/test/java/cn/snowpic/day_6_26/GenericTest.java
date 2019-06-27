package cn.snowpic.day_6_26;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

/**
 * @className GenericTest
 * @description Generic test
 * @author lf
 * @time 2019/6/26 8:31
 **/

public class GenericTest {

    @Test
    public void test1() {
        Float f1 = 1.0f;
        Float f2 = 1.0f;
        Double d1 = 1.0;
        boolean b1 = f1.equals(f2);
        boolean b2 = f1.equals(d1);
        System.out.println();
    }

    /**
     * test2
     * @author lf
     * @time 2019/6/27 13:55
     */
    @Test
    public void test2() {
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < 20) {
            set.add(random.nextInt(20) + 1);
        }
        System.out.println(set);
    }
}
