/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_06;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-06 22:19:43
 */
public class GenericTest {

    /**
     * reverse string
     *
     * @author lf
     * @time 2020-02-06 22:19:38
     * @param input input
     * @return String
     */
    private String reverseString(String input) {
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return new String(array);
    }

    /**
     * reverse
     *
     * @author lf
     * @time 2020-02-06 22:19:32
     * @param input input
     * @return String
     */
    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    @Test
    public void test1() {
        String input = "hello";

        String reverseString = reverseString(input);

        String reverse = reverse(input);

        System.out.println("reverse = " + reverse);

        System.out.println("reverseString = " + reverseString);
    }
}
