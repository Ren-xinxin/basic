/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_23;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-23 16:44:40
 */
public class GenericTest {

    private String reverse(String input) {
        String[] split = input.trim().split("\\s+");
        int left = 0, right = split.length - 1;
        while (left < right) {
            // swap
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", split);
    }

    @Test
    public void test1() {
        String input = "the sky is blue";
        String reversed = reverse(input);
        System.out.println("reversed = " + reversed);
    }
}
