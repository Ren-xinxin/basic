package cn.snowpic.year_2019.month_07.day_03;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className GenericTest
 * @description generic test
 * @author lf
 * @time 2019/7/3 8:42
 **/

public class GenericTest {

    @Test
    public void test1() {
        //System.arraycopy(); has highly effective
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Thread() {
            @Override
            public void run() {
                System.out.println(".......");
            }
        });
        int i = System.identityHashCode(executorService);
        System.out.println(i);
    }

    @Test
    public void test2() {
        short s = 1;
        //s = s + 1;//variable s may not has been initialized...
        s += 1;
        System.out.println(s);
    }
}
