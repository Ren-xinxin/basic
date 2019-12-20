/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_17;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/17 0:12
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/12/17 0:16
     */
    @Test
    public void test1() {
        System.out.println(Arrays.toString(findSum(new int[]{2, 7, 12, 15}, 14)));
    }

    /**
     * find sum
     * @author lf
     * @time 2019/12/17 0:15
     * @param arrays arrays
     * @param target target
     * @return int[]
     */
    private int[] findSum(int[] arrays, int target) {
        for (int i = 0; i < arrays.length; i++) {
            int other = target - arrays[i];
            for (int j = i + 1; j < arrays.length; j++) {
                if (other == arrays[j]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * get majority of an array
     * @author lf
     * @time 2019/12/17 23:16
     */
    @Test
    public void test2() {
        System.out.println(majority(new int[]{1, 2, 1, 3, 4, 5, 6, 7, 7, 9, 4, 4, 4, 4, 4}));
    }

    /**
     * majority
     * @author lf
     * @time 2019/12/17 23:16
     * @param arrays arrays
     * @return int
     */
    private int majority(int[] arrays) {
        // int majority = arrays[0];
        int majority = -1;
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (count == 0 || majority == arrays[i]) {
                count++;
                majority = arrays[i];
            } else {
                count--;
            }
        }
        return majority;
    }
}