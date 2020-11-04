/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_04;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeNums(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1, 1, 0};
        int[] nums4 = {2};
        mergeNums(nums3, 2, nums4, 1);
        System.out.println(Arrays.toString(nums3));
    }

    private void mergeNums(int[] originNums, int originNumsSize, int[] targetNums, int targetNumsSize) {
        int i = originNumsSize - 1;
        int j = targetNumsSize - 1;
        int cursor = originNumsSize + targetNumsSize - 1;

        while (i >= 0 && j >= 0) {
            if (originNums[i] > targetNums[j]) {
                originNums[cursor--] = originNums[i--];
            } else {
                originNums[cursor--] = targetNums[j--];
            }
        }

        while (j >= 0) {
            originNums[cursor--] = targetNums[j--];
        }

        // very clear of miss code below
        // while (i >= 0) {
        //     originNums[cursor--] = targetNums[i--];
        // }
    }
}