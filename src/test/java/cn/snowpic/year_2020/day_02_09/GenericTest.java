/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_09;

import org.junit.Test;

public class GenericTest {

    /**
     * reverse half count
     *
     * @author lf
     * @time 2020-02-09 18:54:20
     * @param input input
     * @param target target
     * @return String
     */
    private String reverseHalfCount(String input, int target) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); i += 2 * target) {
            int left = i;
            int right = i + target - 1;
            // ensure index will not out of bound
            right = right < input.length() ? right : input.length() - 1;
            while (left < right) {
                char tep = chars[left];
                chars[left] = chars[right];
                chars[right] = tep;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    @Test
    public void test1() {
        String str = "abcdefg";

        String reversed = reverseHalfCount(str, 2);
        System.out.println("reversed = " + reversed);
    }
}
