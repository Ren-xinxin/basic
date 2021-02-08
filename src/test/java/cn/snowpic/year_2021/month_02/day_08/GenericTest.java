/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_08;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(calcExpression("1+2+3-4"));
        System.out.println(calcExpression("1+2+3-5"));
    }

    private int calcExpression(String expression) {
        return Arrays.stream(expression
                .replaceAll("[ ]+", "")
                .replaceAll("-", "+-")
                .split("\\+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    @Test
    public void test2() {
        int num = getMaxIncreaseSubarray(new int[]{1, 3, 5, 4, 7});
        System.out.println(num);
        System.out.println(getMaxIncreaseSubarray(new int[]{2, 2, 2, 2, 2}));
    }

    private int getMaxIncreaseSubarray(int[] array) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        max = Math.max(count, max);
        return max;
    }
}
