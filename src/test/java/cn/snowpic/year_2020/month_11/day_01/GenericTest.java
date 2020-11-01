/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_01;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 6};
        int index1 = searchInsertedIndex(nums, 5);
        System.out.println(index1);

        int index2 = searchInsertedIndex(nums, 2);
        System.out.println(index2);

        int index3= searchInsertedIndex(nums, 7);
        System.out.println(index3);
    }

    private int searchInsertedIndex(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < target && nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }
}