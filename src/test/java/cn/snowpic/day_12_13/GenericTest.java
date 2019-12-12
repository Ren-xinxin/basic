/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_12_13;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/13 0:10
 */
public class GenericTest {

    @Test
    public void test1() {
        int[] arrays = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(arrays));
    }

    public int maxSum(int[] arrays) {
        int max1 = arrays[0];
        int max2 = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            max1 = Math.max(arrays[i], max1 + arrays[i]);
            max2 = Math.max(max1, max2);
        }
        return max2;
    }
}
