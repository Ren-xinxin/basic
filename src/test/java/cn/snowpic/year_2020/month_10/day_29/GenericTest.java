/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_29;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums = {2, 3, 3, 2};
        int len = removeElements(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }

        System.out.println();

        int[] nums1 = {0, 1, 2, 2, 3, 0, 4, 2};
        int len1 = removeElements(nums1, 2);
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i]);
        }
    }

    private int removeElements(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != val) {
                nums[index++] = curr;
            }
        }
        return index;
    }
}