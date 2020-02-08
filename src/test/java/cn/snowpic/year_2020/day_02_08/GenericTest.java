/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_08;

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
}
