/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_03;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        boolean match1 = executeMatch("aaa", "a*");
        System.out.println("match1 = " + match1);
        boolean match2 = executeMatch("acd", "a*cd");
        System.out.println("match2 = " + match2);
    }

    /**
     * execute match
     *
     * @author Little Flower
     * @date 2020-04-03 21:56:55
     * @param input input
     * @param pattern pattern
     * @return boolean
     */
    private boolean executeMatch(String input, final String pattern) {
        return match(input, pattern, pattern.length() - 1, 0);
    }

    /**
     * match
     *
     * @author Little Flower
     * @date 2020-04-03 21:55:59
     * @param input input
     * @param pattern pattern
     * @param patternIndex pattern index
     * @param used used
     * @return boolean
     */
    private boolean match(String input, final String pattern, int patternIndex, int used) {
        if (patternIndex < 0) {
            return false;
        }
        int len = input.length();
        int currIndex = len - 1 - used;

        char curr = pattern.charAt(patternIndex--);
        if (curr == '*') {
            curr = pattern.charAt(patternIndex--);
            for (int i = currIndex; i >= 0; i--) {
                if (notSingleMatch(input, curr, i)) {
                    return false;
                }
                for (int j = i; j < currIndex; j++) {
                    if (notSingleMatch(input, curr, j)) {
                        return false;
                    }
                }
                int except = len - i;
                if (except == len || match(input, pattern, patternIndex, except)) {
                    return true;
                }
            }
        }
        if (notSingleMatch(input, curr, currIndex)) {
            return false;
        }
        int except = used + 1;
        return except == len || match(input, pattern, patternIndex, except);
    }

    /**
     * not single match
     *
     * @author Little Flower
     * @date 2020-04-03 21:49:29
     * @param input input
     * @param curr curr
     * @param index index
     * @return boolean
     */
    private boolean notSingleMatch(String input, char curr, int index) {
        return curr != '.' && curr != input.charAt(index);
    }
}
