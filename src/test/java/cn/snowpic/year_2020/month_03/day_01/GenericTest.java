/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_01;

import cn.snowpic.util.CommonUtils;
import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-03-01 13:53:02
 */
public class GenericTest {

    /**
     * palindrome count
     *
     * @author lf
     * @time 2020-03-01 13:56:19
     * @param input input
     * @return int
     */
    private int palindromeCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String current = input.substring(i, j);
                if (CommonUtils.isPalindrome(current)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test1() {
        int count = palindromeCount("aaa");
        System.out.println("count = " + count);
    }
}
