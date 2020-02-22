/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_21;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-21 23:25:07
 */
public class GenericTest {

    /**
     * spilt2 ip
     *
     * @author lf
     * @time 2020-02-22 15:36:43
     * @param input input
     * @param index index
     * @param dotCount dot count
     * @param str str
     * @param result result
     */
    private void spilt2Ip(String input, int index, int dotCount, String str, List<String> result) {
        if (dotCount == 3) {
            String last = input.substring(index);
            if (!StringUtils.isBlank(last) && Integer.parseInt(last) < 256) {
                result.add(str + last);
            }
            return;
        }
        int len = Math.min(index + 3, input.length());
        for (int i = index; i < len; i++) {
            // whether the start is zero.
            if (Integer.parseInt(input.charAt(index) + "") == 0) {
                return;
            }
            int nextIndex = i + 1;
            String current = input.substring(index, nextIndex);
            if (Integer.parseInt(current) > 255) {
                return;
            }
            spilt2Ip(input, nextIndex, dotCount + 1, str + current + ".", result);
        }
    }

    /**
     * spit2 ip
     *
     * @author lf
     * @time 2020-02-22 15:40:19
     * @param input input
     * @return @List<String>
     */
    private List<String> spit2Ip(String input) {
        if (input.length() > 3 * 4) {
            throw new IllegalArgumentException("Ip string's length must less than 3 * 4!");
        }
        if (input.matches("^//d+$")) {
            throw new NumberFormatException("Ip string's format is incorrect.");
        }
        List<String> result = new ArrayList<>();
        spilt2Ip(input, 0, 0, "", result);
        return result;
    }

    @Test
    public void test1() {
        String input = "25525511135";
        List<String> list = spit2Ip(input);
        System.out.println("list = " + list);

        System.out.println(spit2Ip("2322133"));
    }

    /**
     * multiply
     *
     * @author lf
     * @time 2020-02-22 18:43:19
     * @param input1 input1
     * @param input2 input2
     * @return String
     */
    private String multiply(String input1, String input2) {
        if (input1.matches("^//d+$") && input2.matches("^//d+$")) {
            throw new IllegalArgumentException("You must entry a pair of numbers");
        }
        input1 = trim(input1);
        input2 = trim(input2);
        // input's length
        int len1 = input1.length();
        int len2 = input2.length();
        // initial a result int array
        int[] result = new int[(len1 + 1) * (len2 + 1) - 1];
        // calculate offset between current multiply result and the int array
        int offset = (result.length - 1) - ((len1 - 1) - (len2 - 1));
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int tep = Integer.parseInt(input1.charAt(i) + "") * Integer.parseInt(input2.charAt(j) + "");
                int currentIndex = i + j + offset;
                result[currentIndex] += tep;
                // deal with the last three numbers within it.
                for (int k = 0; k < 2; k++) {
                    tep = result[currentIndex - k] / 10;
                    if (tep < 1) break;
                    result[currentIndex - k] %= 10;
                    result[(currentIndex) - k - 1] += tep % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            sb.append(value);
        }
        return trim(sb.toString());
    }

    /**
     * trim
     *
     * @author lf
     * @time 2020-02-22 18:39:09
     * @param input input
     * @return String
     */
    private String trim(String input) {
        while (input.length() != 0 && input.charAt(0) == '0') {
            input = input.substring(1);
        }
        return input.length() == 0 ? "0" : input;
    }

    @Test
    public void test2() {
        String multiplied = multiply("60003", "0");
        System.out.println("multiplied = " + multiplied);
    }
}
