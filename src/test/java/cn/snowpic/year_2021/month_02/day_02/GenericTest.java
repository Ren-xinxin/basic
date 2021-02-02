/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_02;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        int len = findMinSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        System.out.println(len);
    }

    private int findMinSubarray(int[] array) {
        // int[] copy = new int[array.length];
        // System.arraycopy(array, 0, copy, 0, array.length);
        int[] copy = array.clone();
        Arrays.sort(copy);
        int start = 0;
        int end = array.length - 1;
        boolean isStart = true;
        for (int i = 0; i < array.length; i++) {
            if (isStart && array[i] != copy[i]) {
                start = i;
                isStart = false;
            }
            if (!isStart && array[i] == copy[i]) {
                end = i - 1;
            }
        }
        return end - start + 1;
    }
}
