/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_05;

import org.junit.Test;

import java.util.Stack;

public class GenericTest {

    @Test
    public void test1() {
        String input = "A man,a plan,a canal:Panama";
        boolean palindrome = isPalindrome(input);
        System.out.println("palindrome = " + palindrome);
    }

    /**
     * is palindrome
     *
     * @author lf
     * @time 2020-02-05 21:11:05
     * @param input input
     * @return boolean
     */
    private boolean isPalindrome(String input) {
        input = input.toLowerCase().trim().replaceAll("[^a-z0-9]", "");
        int length = input.length();
        if (length == 0 || length == 1) {
            return true;
        }
        if (length % 2 == 0) {
            return false;
        }
        int mid = length / 2 + 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < mid - 1; i++) {
            stack.push(input.charAt(i));
        }
        for (int i = mid; i < length; i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
