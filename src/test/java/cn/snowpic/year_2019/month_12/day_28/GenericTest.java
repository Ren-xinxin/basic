/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.month_12.day_28;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/28 23:32
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/12/28 23:41
     */
    @Test
    public void test1() {
        int[] array = {1, 12, -5, -6, 50, 3};
        double average = maxAverage(array, 4);
        System.out.println("average = " + average);
    }

    /**
     * max average
     * @author lf
     * @time 2019/12/28 23:33
     * @param array array
     * @param k k
     * @return int
     */
    private double maxAverage(int[] array, int k) {
        if (array.length < k) {
            throw new IllegalArgumentException("the array's length must greater than k");
        }
        double maxAvg = 0;
        for (int i = k - 1; i < array.length; i++) {
            int sum = 0;
            for (int j = (i + 1) - k; j <= i; j++) {
                sum += array[j];
            }
            maxAvg = Math.max(maxAvg, sum * 1.0 / k);
        }
        return maxAvg;
    }
}
