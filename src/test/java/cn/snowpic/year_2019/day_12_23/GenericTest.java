/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_23;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/23 20:42
 */
public class GenericTest {

    /**
     * test1 of missing number
     * @author lf
     * @time 2019/12/23 21:27
     */
    @Test
    public void test1() {
        int number = missingNumber(new int[]{3, 0, 1, 2, 6, 4});
        System.out.println("number = " + number);
    }

    /**
     * missing number
     * @author lf
     * @time 2019/12/23 20:45
     * @param arrays arrays
     * @return int
     */
    private int missingNumber(int[] arrays) {
        int xor = 0;
        int i = 0;
        for (; i < arrays.length; i++) {
            xor = xor ^ i ^ arrays[i];
            // 0 -> 0 -> 3 i0 a3 000 000 [000] 011 [011]
            // 3 -> 2 -> 2 i1 a0 011 001 [010] 000 [010]
            // 2 -> 0 -> 1 i2 a1 010 010 [000] 001 [001]
            // 1 -> 2 -> 0 i3 a2 001 011 [010] 010 [000]
            // 0 -> 4 -> 2 i4 a6 000 100 [100] 110 [010]
            // 2 -> 7 -> 3 i5 a4 010 101 [111] 100 [011]
        }
        // 3 -> 5 011 110 [101]
        return xor ^ i;
    }
}
