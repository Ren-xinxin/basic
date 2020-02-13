/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.month_12.day_22;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/22 16:23
 */
public class GenericTest {

    /**
     * test1 find the second maximum
     * @author lf
     * @time 2019/12/22 16:24
     */
    @Test
    public void test1() {
        System.out.println(findThe2nd(new int[]{1, 2, 4, 5, 6, 3, 99, 32}));
    }

    /**
     * find the2nd
     * @author lf
     * @time 2019/12/22 16:29
     * @param arrays arrays
     * @return int
     */
    private int findThe2nd(int[] arrays) {
        int max1 = -1, max2 = -1;

        for (int i = 0; i < arrays.length; i++) {
            max1 = Math.max(arrays[i], max1);
        }

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == max1) {
                continue;
            }
            max2 = Math.max(arrays[i], max2);
        }
        return max2;
    }
}
