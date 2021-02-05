/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_05;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        prime(10);
        prime(100);
        prime(1000);
        prime(10000);
        prime(100000);
        prime(1000000);
    }

    private void prime(int len) {
        boolean[] flag = new boolean[len + 1];
        for (int i = 2; i <= Math.sqrt(len); i++) {
            for (int j = i; i * j <= len; j++) {
                flag[i * j] = true;
            }
        }
        for (int i = 2; i < len; i++) {
            if (!flag[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    @Test
    public void test2() {
        System.out.println(getMaxAvg(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(getMaxAvg(new int[]{1, 12, -5, -6, 50, 3}, 3));

        System.out.println(getMaxAvg2(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(getMaxAvg2(new int[]{1, 12, -5, -6, 50, 3}, 3));
    }

    private double getMaxAvg(int[] nums, int len) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < nums.length - len + 1; i++) {
            int temp = 0;
            for (int j = i; j < i + len; j++) {
                temp += nums[j];
            }
            double avg = temp * 1.0 / len;
            if (avg > max) {
                max = avg;
            }
        }
        return max;
    }

    private double getMaxAvg2(int[] nums, int k) {
        double max = Double.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                sum -= nums[i - k];
            }
            sum += nums[i];
            if (i + 1 >= k) {
                max = Math.max(max, sum * 1.0 / k);
            }
        }
        return max;
    }
}
