/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_01.day_31;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int count = findConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(count);
    }

    private int findConsecutiveOnes(int[] array) {
        int count = 0;
        int max = 0;
        for (int i : array) {
            if (i == 0) {
                count = 0;
            } else {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
