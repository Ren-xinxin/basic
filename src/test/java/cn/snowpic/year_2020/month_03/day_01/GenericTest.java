/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_01;

import cn.snowpic.util.CommonUtils;
import org.junit.Test;

import java.util.Stack;

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

    /**
     * validate
     *
     * @author lf
     * @time 2020-03-01 16:07:39
     * @param origin origin
     * @param container container
     * @param currentIndex current index
     * @param current current
     * @return boolean
     */
    private boolean validate(String origin, Stack<Character> container, int currentIndex, Character current) {
        if (currentIndex == origin.length()) {
            return container.isEmpty();
        }
        if (current == null && origin.charAt(currentIndex) == '*') {
            boolean validate1 = validate(origin, stackClone(container), currentIndex, '(');
            boolean validate2 = validate(origin, stackClone(container), currentIndex, ')');
            // any character will be ok
            boolean validate3 = validate(origin, stackClone(container), currentIndex, '-');
            return validate1 || validate2 || validate3;
        } else {
            current = current == null ? origin.charAt(currentIndex) : current;
            switch (current) {
                case '(':
                    container.push(current);
                    break;
                case ')':
                    if (container.isEmpty()) return false;
                    container.pop();
                    break;
                case '-':
                    break;
                default:
                    return false;
            }
            return validate(origin, container, currentIndex + 1, null);
        }
    }

    /**
     * stack clone
     *
     * @author lf
     * @time 2020-03-01 16:02:35
     * @param origin origin
     * @return @Stack<Character>
     */
    @SuppressWarnings("unchecked")
    private Stack<Character> stackClone(Stack<Character> origin) {
        return (Stack<Character>) (origin.clone());
    }

    /**
     * validate
     *
     * @author lf
     * @time 2020-03-01 16:08:39
     * @param input input
     * @return boolean
     */
    private boolean validate(String input) {
        if (!input.matches("^[()*]*$")) throw new IllegalArgumentException("Input is incorrect.");
        return validate(input, new Stack<>(), 0, null);
    }

    @Test
    public void test2() {
        boolean validate1 = validate("");
        System.out.println("validate1 = " + validate1);

        boolean validate2 = validate("()");
        System.out.println("validate1 = " + validate2);

        boolean validate3 = validate("(*)");
        System.out.println("validate1 = " + validate3);

        boolean validate4 = validate("(*))");
        System.out.println("validate1 = " + validate4);
    }
}
