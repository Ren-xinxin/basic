/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.month_01.day_17;

import org.junit.Test;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-17 0:39
     */
    @Test
    public void test1() {
        int[] heights = {1, 2, 5, 7, 8, 10, 12, 2, 34};
        int area = maxContainerArea(heights);
        System.out.println("area = " + area);
    }

    /**
     * max container area
     *
     * @author lf
     * @time 2020-01-17 0:39
     * @param array array
     * @return int
     */
    private int maxContainerArea(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                max = Math.max(max, Math.min(array[j], array[i]) * (j - i));
            }
        }
        return max;
    }
}
