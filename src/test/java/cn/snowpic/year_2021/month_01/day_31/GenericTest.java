/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_01.day_31;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        int sum = getMaxSum(new int[]{1, 4, 3, 2});
        System.out.println(sum);
    }

    private int getMaxSum(int[] array) {
        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];

        }
        return sum;
    }
}
