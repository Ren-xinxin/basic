/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_03;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3};
        int[] result1 = plusOne(nums1, 9);
        System.out.println(Arrays.toString(result1));

        int[] nums2 = {9, 9, 9};
        int[] result2 = plusOne(nums2, 3);
        System.out.println(Arrays.toString(result2));
    }

    private int[] plusOne(int[] nums, int val) {
        int added = 0;
        // plus one
        nums[nums.length - 1] += val;

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i] + added;
            nums[i] = curr % 10;
            added = curr / 10;
        }
        if (added == 0) {
            return nums;
        }
        int[] result = new int[nums.length + 1];
        result[0] = added;
        System.arraycopy(nums, 0, result, 1, nums.length);

        return result;
    }
}