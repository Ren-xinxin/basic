/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_02;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum1 = maxSumOfSubarray(nums1);

        int[] nums2 = {-2, 1, -3};
        int sum2 = maxSumOfSubarray(nums2);

        System.out.println(sum1);
        System.out.println(sum2);
    }

    private int maxSumOfSubarray(int[] nums) {
        int result = Integer.MIN_VALUE;

        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(last + nums[i], nums[i]);
            if (temp > result) {
                result = temp;
            }
            last = temp;
        }

        return result;
    }
}