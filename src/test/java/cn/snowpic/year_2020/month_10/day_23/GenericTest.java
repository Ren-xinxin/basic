/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_23;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int[] result = findSolution(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    private int[] findSolution(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int another = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == another) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}