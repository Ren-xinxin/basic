/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_21;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findMissingNum(new int[]{0, 1, 3}));
        System.out.println(findMissingNum(new int[]{0, 1, 2, 5, 4}));
    }

    /**
     * find missing num
     *
     * @author Little Flower
     * @date 2020-11-21 22:41:18
     * @param array array
     * @return int
     */
    private int findMissingNum(int[] array) {
        int num = 0;
        for (int i = 1; i <= array.length; i++) {
            num ^= i;
        }
        for (int i : array) {
            num ^= i;
        }
        return num;
    }
}
