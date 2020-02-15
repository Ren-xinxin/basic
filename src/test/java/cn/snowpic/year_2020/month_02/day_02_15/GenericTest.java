/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_02_15;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-15 13:53:27
 */
public class GenericTest {

    /**
     * max sub palindrome
     *
     * @author lf
     * @time 2020-02-15 14:18:43
     * @param input input
     * @return int
     */
    private int maxSubPalindrome(String input) {
        int result = -1;
        for (int i = 0; i < input.length(); i++) {
            int center = expandWithCenter(input, i - 1, i + 1, true);
            int right = expandWithCenter(input, i, i + 1, false);
            int left = expandWithCenter(input, i - 1, i, false);
            result = Math.max(Math.max(Math.max(right, center), left), result);
        }
        return result;
    }

    /**
     * expand with center
     *
     * @author lf
     * @time 2020-02-15 14:18:49
     * @param origin origin
     * @param left left
     * @param right right
     * @param isSingleCenter is single center
     * @return int
     */
    private int expandWithCenter(String origin, int left, int right, boolean isSingleCenter) {
        if (left < 0 || right > origin.length() - 1) {
            return 1;
        }
        while (left >= 0 && right < origin.length()) {
            if (origin.charAt(left) != origin.charAt(right)) break;
            left--;
            right++;
        }
        return isSingleCenter ? (right - left - 1) : right - left;
    }

    @Test
    public void test1() {
        int subPalindrome = maxSubPalindrome("babad");
        System.out.println("subPalindrome = " + subPalindrome);
    }
}
