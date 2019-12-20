package cn.snowpic.year_2019.day_08_27;

import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/27 22:55
 **/

public class GenericTest {

    @Test
    public void test1() {
        Callable<Integer> callable = () -> 5;
    }
}
