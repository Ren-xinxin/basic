/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_08;

import org.junit.Test;

public class GenericTest {

    /**
     * compress
     *
     * @author lf
     * @time 2020-02-08 18:56:23
     * @param inputs inputs
     * @return String
     */
    private String compress(char[] inputs) {
        char prev = inputs[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] == prev) {
                count++;
            } else {
                sb.append(prev);
                if (count > 1) {
                    sb.append(count);
                }
                prev = inputs[i];
                count = 1;
            }
        }
        sb.append(prev);
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        char[] inputs = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        String compressed = compress(inputs);
        System.out.println("compressed = " + compressed);
    }

    /**
     * repeated sub
     *
     * @author lf
     * @time 2020-02-08 19:50:45
     * @param input input
     * @return boolean
     */
    private boolean repeatedSub(String input) {
        rxx:
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.length() % (i + 1) == 0) {
                int start = i + 1;
                String pattern = input.substring(0, start);
                int end = start * 2;
                while (end <= input.length()) {
                    String sub = input.substring(start, end);
                    if (!pattern.equals(sub)) {
                        continue rxx;
                    }
                    start = end;
                    end = start + (i + 1);
                }
                System.out.println("repeated sub = " + pattern);
                return true;
            }
        }
        return false;
    }

    @Test
    public void test2() {
        String input = "abab";
        boolean repeatedSub = repeatedSub(input);
        System.out.println("repeatedSub = " + repeatedSub);
        String input1 = "abcabcabcabc";

        boolean repeatedSub1 = repeatedSub(input1);
        System.out.println("repeatedSub1 = " + repeatedSub1);
    }

    /**
     * is correct capital letters
     *
     * @author lf
     * @time 2020-02-08 20:15:21
     * @param input input
     * @return boolean
     */
    private boolean isCorrectCapitalLetters(String input) {
        boolean isAllCapital = Character.isUpperCase(input.charAt(input.length() - 1));
        for (int i = 0; i < input.length() - 1; i++) {
            if (isAllCapital) {
                if (Character.isLowerCase(input.charAt(i))) {
                    return false;
                }
            } else {
                // input's char at 0 can be lower case or upper case
                if (i > 0 && Character.isUpperCase(input.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test3() {
        String input = "Flag";
        boolean capitalLetters = isCorrectCapitalLetters(input);
        System.out.println("capitalLetters = " + capitalLetters);
    }

    /**
     * max specific sub sequence
     *
     * @author lf
     * @time 2020-02-08 20:43:03
     * @param str1 str1
     * @param str2 str2
     * @return int
     */
    private int maxSpecificSubSequence(String str1, String str2) {
        if (str1.equals(str2)) {
            return -1;
        }
        return Math.max(str1.length(), str2.length());
    }

    @Test
    public void test4() {
        String str1 = "aba", str2 = "cdcf";
        int len = maxSpecificSubSequence(str1, str2);
        System.out.println("len = " + len);
    }
}
