/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_28;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums1 = {1, 1, 2};
        int rd1 = removeDuplicates(nums1);
        for (int i = 0; i < rd1; i++) {
            System.out.print(nums1[i]);
        }
        System.out.println();
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int rd2 = removeDuplicates(nums2);
        for (int i = 0; i < rd2; i++) {
            System.out.print(nums2[i]);
        }
    }

    private int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != nums[index]) {
                nums[++index] = curr;
            }
        }
        return index + 1;
    }
}