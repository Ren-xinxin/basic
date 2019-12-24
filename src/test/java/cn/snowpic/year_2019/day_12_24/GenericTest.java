/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_24;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/24 20:20
 */
public class GenericTest {

    @Test
    public void test1() {
        System.out.println(maxOne(new int[]{1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1}));
    }

    /**
     * max one
     * @author lf
     * @time 2019/12/24 20:22
     * @param arrays arrays
     * @return int[]
     */
    private int maxOne(int[] arrays) {
        int max = -1;
        int count = 0;
        for (int array : arrays) {
            if (array == 1) {
                max = Math.max(max, ++count);
            } else {
                count = 0;
            }
        }
        return max;
    }

}
