/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.day_10;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2020/1/10 0010 23:14
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2020-01-10 23:33
     */
    @Test
    public void test1() {
        int[] array1 = {3, 6, 1, 0};
        int pivotNumber = pivotNumber(array1);
        System.out.println("pivotNumber = " + pivotNumber);
        int[] array2 = {1, 2, 3, 4};
        int pivotNumber2 = pivotNumber(array2);
        System.out.println("pivotNumber2 = " + pivotNumber2);

    }

    /**
     * pivot number
     * @author lf
     * @time 2020-01-10 23:33
     * @param array array
     * @return int
     */
    private int pivotNumber(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("array's length must greater than 2.");
        }
        int[] clone = array.clone();
        Arrays.sort(clone);
        int length = clone.length;
        if (clone[length - 1] < clone[length - 2] * 2) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == clone[length - 1]) {
                return i;
            }
        }
        return -1;
    }
}
