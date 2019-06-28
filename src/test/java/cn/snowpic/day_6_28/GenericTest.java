package cn.snowpic.day_6_28;

import org.junit.Test;

/**
 * @className GenericTest
 * @description generic test
 * @author lf
 * @time 2019/6/28 10:54
 **/

public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/6/28 13:20
     */
    @Test
    public void test1() {
        System.out.println("What a wonderful day today.....");
    }

    /**
     * test2 another test ....
     * @author lf
     * @time 2019/6/28 15:16
     */
    @Test
    public void test2() {
        System.out.println("I am confused about something," +
                "but I can't resolve it");
    }

    /**
     * test3 bit operate 'and'
     * @author lf
     * @time 2019/6/28 16:40
     */
    @Test
    public void test3() {
        System.out.println(2 & 3);
        System.out.println(-2 >> 1);
        System.out.println("I am in home");
        System.out.println("some other things....");
    }
}
