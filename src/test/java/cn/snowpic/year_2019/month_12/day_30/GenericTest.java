/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.day_30;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/30 19:41
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/12/30 19:46
     */
    @Test
    public void test1() {
        int[] array = {1, 3, 5, 4, 7};
        int continuousDecrease = maxContinuousDecrease(array);
        System.out.println("continuousDecrease = " + continuousDecrease);
    }

    /**
     * max continuous decrease
     * @author lf
     * @time 2019/12/30 19:43
     * @param array array
     * @return int
     */
    private int maxContinuousDecrease(int[] array) {
        int max = 0;
        int start = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] >= array[i]) {
                max = Math.max(max, i - start);
                start = i;
            }
        }
        max = Math.max(max, array.length - start);
        return max;
    }
}
