/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_02_15;

import org.apache.commons.lang.text.StrBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        String input = "babad";
        int subPalindrome = maxSubPalindrome(input);
        System.out.println("subPalindrome = " + subPalindrome);

        String palindrome = subPalindrome(input);
        System.out.println("palindrome = " + palindrome);
    }

    /**
     * expand around center
     *
     * @author lf
     * @time 2020-02-15 16:15:16
     * @param origin origin
     * @param left left
     * @param right right
     * @return int
     */
    private int expandAroundCenter(String origin, int left, int right) {
        while (left >= 0 && right < origin.length() && origin.charAt(left) == origin.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * sub palindrome
     *
     * @author lf
     * @time 2020-02-15 16:35:23
     * @param input input
     * @return String
     */
    private String subPalindrome(String input) {
        String result = "";
        int start = 0, end = 0;
        for (int i = 0; i < input.length(); i++) {
            int len1 = expandAroundCenter(input, i, i);
            int len2 = expandAroundCenter(input, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = start + len;
                result = input.substring(start, end);
            }
        }
        return result;
    }

    /**
     * convert
     *
     * @author lf
     * @time 2020-02-15 17:52:31
     * @param input input
     * @param rowNumber row number
     * @return String
     */
    private String convert(String input, int rowNumber) {
        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < Math.min(input.length(), rowNumber); i++) {
            sbs.add(new StringBuilder());
        }
        boolean down = false;
        int currRow = 0;
        for (char c : input.toCharArray()) {
            if (currRow == 0 || currRow == sbs.size() - 1) {
                down = !down;
            }
            sbs.get(currRow).append(c);
            currRow += down ? 1 : -1;
        }
        StrBuilder ret = new StrBuilder();
        sbs.forEach(ret::append);
        return ret.toString();
    }

    @Test
    public void test2() {
        String input = "PAYPALISHIRING";

        String convert = convert(input, 3);
        System.out.println("convert = " + convert);
    }
}
