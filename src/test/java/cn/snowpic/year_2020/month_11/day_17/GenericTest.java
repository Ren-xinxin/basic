/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_17;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author Little Flower
 * @date 2020-11-17 22:55:45
 */
public class GenericTest {

    @Test
    public void test1() {
        int mode1 = findMajority(new int[]{3, 2, 3});
        System.out.println("mode1 = " + mode1);

        int mode2 = findMajority(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println("mode2 = " + mode2);
    }

    private int findMajority(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else if (nums[i] != majority) {
                count--;
            } else {
                count++;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            }
        }
        if (count * 2 <= nums.length) {
            throw new IllegalArgumentException("the majority element doesn't exist in the array");
        }

        return majority;
    }
}
