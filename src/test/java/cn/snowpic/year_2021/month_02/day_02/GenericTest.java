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
        System.out.println(findMinSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    private int findMinSubarray(int[] array) {
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

    private int findMinSubarray2(int[] array) {
        int start = 0;
        int end = 0;
        int max = array[0];
        int len = array.length;
        int min = array[len - 1];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[len - 1 - i]);
            if (array[i] < max) {
                end = i;
            }
            if (array[len - 1 - i] > min) {
                start = len - 1 - i;
            }
        }
        return end - start + 1;
    }
}
