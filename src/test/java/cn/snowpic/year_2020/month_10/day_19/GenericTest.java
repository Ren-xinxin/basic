/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_19;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};

        System.out.println(getMaxSubByTraverse(nums1));
        System.out.println(getMaxSubByTraverse(nums2));

        System.out.println(getMaxSubByDynamicProgramming(nums1));
        System.out.println(getMaxSubByDynamicProgramming(nums2));
    }

    /**
     * get max sub by traverse
     *
     * @author Little Flower
     * @date 2020-10-19 22:56:52
     * @param nums nums
     * @return int
     */
    private int getMaxSubByTraverse(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int next = i + 1;
            for (int j = next; j <= nums.length; j++) {
                int temporary = nums[i];
                for (int k = next; k < nums.length; k++) {
                    temporary *= nums[k];
                }
                if (temporary > max) {
                    max = temporary;
                }
            }
        }
        return max;
    }

    /**
     * get max sub by dynamic programming
     *
     * @author Little Flower
     * @date 2020-10-19 23:08:52
     * @param nums nums
     * @return int
     */
    private int getMaxSubByDynamicProgramming(int[] nums) {
        int max = nums[0];
        int positive = nums[0];
        int negative = nums[0];
        for (int num : nums) {
            int temp = positive;
            positive = Math.max(num, num * (num > 0 ? positive : negative));
            negative = Math.min(num, num * (num > 0 ? negative : temp));

            max = Math.max(positive, negative);
        }
        return max;
    }
}