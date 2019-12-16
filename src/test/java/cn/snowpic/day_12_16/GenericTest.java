/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_12_16;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/16 21:45
 */
public class GenericTest {

    /**
     * maximum profit algorithm
     * @author lf
     * @time 2019/12/16 21:58
     */
    @Test
    public void test1() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * max profit
     * @author lf
     * @time 2019/12/16 21:58
     * @param arrays arrays
     * @return int
     */
    private int maxProfit(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        int buy = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] < buy) {
                buy = arrays[i];
            } else {
                max = Math.max(max, arrays[i] - buy);
            }
        }
        return max;
    }
}
