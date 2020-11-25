/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_25;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int count = findContinuousOne(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(count);
    }

    private int findContinuousOne(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                int nextIndex = i + 1;
                if (nextIndex == nums.length || nums[nextIndex] == 0) {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }
        return max;
    }
}
