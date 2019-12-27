/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_27;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/27 20:42
 */
public class GenericTest {

    /**
     * test1 find the maximum continuous 1 sum
     * @author lf
     * @time 2019/12/27 20:51
     */
    @Test
    public void test1() {
        int maxOne = findMaxOne(new int[]{0, 1, 1, 1, 0, 1, 1, 1, 1});
        System.out.println("maxOne = " + maxOne);
    }

    /**
     * find max one
     * @author lf
     * @time 2019/12/27 20:43
     * @param array binary array
     * @return int
     */
    private int findMaxOne(int[] array) {
        int count = 0;
        int max = 0;
        for (int value : array) {
            if (value == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        // ensure the max value if the last element is 1
        max = Math.max(max, count);
        return max;
    }
}
