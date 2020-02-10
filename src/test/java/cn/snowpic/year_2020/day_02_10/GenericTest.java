/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_10;

import org.junit.Test;

public class GenericTest {

    /**
     * reverse word
     *
     * @author lf
     * @time 2020-02-10 11:02:56
     * @param input input
     * @return String
     */
    private String reverseWord(String input) {
        String[] split = input.split("[ ]+");
        for (int i = 0; i < split.length; i++) {
            split[i] = reverse(split[i]);
        }
        return String.join(" ", split);
    }

    /**
     * reverse
     *
     * @author lf
     * @time 2020-02-10 11:02:50
     * @param input input
     * @return String
     */
    private String reverse(String input) {
        int left = 0;
        int right = input.length() - 1;
        char[] chars = input.toCharArray();
        while (left < right) {
            char tep = chars[left];
            chars[left] = chars[right];
            chars[right] = tep;
            left++;
            right--;
        }
        return new String(chars);
    }

    @Test
    public void test1() {
        String input = "Let's take LeetCode contest";
        String reverseWord = reverseWord(input);

        System.out.println("reverseWord = " + reverseWord);
    }
}
