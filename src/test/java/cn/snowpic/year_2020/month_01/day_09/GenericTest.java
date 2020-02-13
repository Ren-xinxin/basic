/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.month_01.day_09;

import org.junit.Test;

import java.util.Arrays;

/**
 * generic test
 * @className GenericTest
 * @author lf
 * @time 2020-01-09 19:49
 */
public class GenericTest {
    /**
     * test1
     * @author lf
     * @time 2020-01-09 19:50
     */
    @Test
    public void test1() {
        int[] array1 = new int[]{1, 0, 0};
        boolean oneBit1 = endWithOneBit(array1);
        System.out.println("oneBit1 = " + oneBit1);

        int[] array2 = new int[]{1, 1, 1, 0};
        boolean oneBit2 = endWithOneBit(array2);
        System.out.println("oneBit2 = " + oneBit2);
    }

    /**
     * end with one bit
     * @author lf
     * @time 2020-01-09 19:47
     * @param array array
     * @return boolean
     */
    private boolean endWithOneBit(int[] array) {
        int len = 0;
        for (; len < array.length - 1; ) {
            if (array[len] == 1) {
                len += 2;
            } else {
                len++;
            }
        }
        return len == array.length - 1;
    }

    /**
     * find pivot
     * @author lf
     * @time 2020-01-09 23:22
     * @param array array
     * @return int
     */
    private int findPivot(int[] array) {
        int sum = Arrays.stream(array).sum();
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentSum == (sum - array[i] - currentSum)) {
                return i;
            }
            currentSum += array[i];
        }
        return -1;
    }

    /**
     * test2 of find pivot
     * @author lf
     * @time 2020-01-09 23:20
     */
    @Test
    public void test2() {
        int[] array1 = {1, 7, 3, 6, 5, 6};
        int pivot1 = findPivot(array1);
        System.out.println("pivot1 = " + pivot1);
    }
}