/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_18;

import org.junit.Test;

import java.util.Arrays;

/**
 * generic test
 * @className GenericTest
 *
 * @author lf
 * @time 2020-01-18 0:10
 */
public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-18 0:10
     */
    @Test
    public void test1() {
        int[] array = {3, 1, 2, 4};
        int[] parity = sortArrayByParity(array);
        System.out.println("parity = " + Arrays.toString(parity));
    }

    /**
     * sort array by parity
     *
     * @author lf
     * @time 2020-01-18 0:09
     * @param array array
     * @return int[]
     */
    private int[] sortArrayByParity(int[] array) {
        int[] result = new int[array.length];
        int head = 0;
        int tail = array.length - 1;
        for (int i : array) {
            if (i % 2 == 0) {
                result[head++] = i;
            } else {
                result[tail--] = i;
            }
        }
        return result;
    }
}
