/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_04;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(findThreeMaxProd(new int[]{1, 2, 3}));
        System.out.println(findThreeMaxProd(new int[]{1, 4, 3, 2}));
        System.out.println(findThreeMaxProd(new int[]{9, 4, 3, 8}));
        System.out.println(findThreeMaxProd(new int[]{-4, -3, -2, -1, 1, 2}));
        System.out.println("===================================");
        System.out.println(findThreeMaxProd2(new int[]{1, 2, 3}));
        System.out.println(findThreeMaxProd2(new int[]{1, 4, 3, 2}));
        System.out.println(findThreeMaxProd2(new int[]{9, 4, 3, 8}));
        System.out.println(findThreeMaxProd2(new int[]{-4, -3, -2, -1, 1, 2}));
    }

    private int findThreeMaxProd(int[] nums) {
        int result = Integer.MIN_VALUE;
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = true;
            for (int j = 0; j < nums.length; j++) {
                if (flag[j]) {
                    continue;
                }
                flag[j] = true;
                for (int k = 0; k < nums.length; k++) {
                    if (flag[k]) {
                        continue;
                    }
                    int temp = nums[i] * nums[j] * nums[k];
                    if (temp > result) {
                        result = temp;
                    }
                }
                flag[j] = false;
            }
            flag[i] = false;
        }
        return result;
    }

    private int findThreeMaxProd2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 3] * nums[len - 2] * nums[len - 1]);
    }
}
