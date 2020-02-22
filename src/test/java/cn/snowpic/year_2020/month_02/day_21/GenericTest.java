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
}
