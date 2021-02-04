/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.day_27;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/27 20:42
 */
public class GenericTest {

    /**
     * test1 find the maximum continuous 1 sum
     * @author lf
     * @time 2019/12/27 20:51
     */
    @Test
    public void test1() {
        int maxOne = findMaxOne(new int[]{0, 1, 1, 1, 0, 1, 1, 1, 1});
        System.out.println("maxOne = " + maxOne);
    }

    /**
     * find max one
     * @author lf
     * @time 2019/12/27 20:43
     * @param array binary array
     * @return int
     */
    private int findMaxOne(int[] array) {
        int count = 0;
        int max = 0;
        for (int value : array) {
            if (value == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        // ensure the max value if the last element is 1
        max = Math.max(max, count);
        return max;
    }

    /**
     * test2 of grow flowers
     * @author lf
     * @time 2019/12/27 21:17
     */
    @Test
    public void test2() {
        boolean flowers = growFlowers(new int[]{1, 0, 0, 0, 1}, 1);
        System.out.println("flowers = " + flowers);
    }

    /**
     * grow flowers
     * @author lf
     * @time 2019/12/27 21:01
     * @param array array 0 presents empty 1 presents there is a flower.
     *              You are not allowed to grow a flower near by another flower.
     * @return boolean
     */
    private boolean growFlowers(int[] array, int flowers) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i == 0 || array[i - 1] == 0)
                    && array[i] == 0
                    && (i == array.length - 1 || array[i + 1] == 0)) {
                if (++count >= flowers) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * test3 maximum of multiply between three elements
     * @author lf
     * @time 2019/12/27 21:23
     */
    @Test
    public void test3() {
        int multiply = maxMultiply(new int[]{5, 8, 3, 2, 6, 1});
        System.out.println("multiply = " + multiply);
    }

    /**
     * max multiply
     * find a bug...
     *
     * @see cn.snowpic.year_2021.month_02.day_04.GenericTest#findThreeMaxProd2(int[])
     * @author lf
     * @time 2019/12/27 21:26
     * @param array array
     * @return int
     */
    private int maxMultiply(int[] array) {
        if (array.length < 3) {
            throw new IllegalArgumentException("The array must contains 3 elements at least");
        }
        Arrays.sort(array);
        int len = array.length;
        return array[len - 1] * array[len - 2] * array[len - 3];
    }
}
