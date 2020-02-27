/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_27;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-27 15:54:24
 */
public class GenericTest {

    private String complexMultiply(String complex1, String complex2) {
        final Pattern pattern = Pattern.compile("^([1-9]\\d{0,10})([+\\-][1-9]\\d{0,10})i$");
        // simplify the input
        complex1 = complex1.replaceAll("\\s+", "");
        complex2 = complex2.replaceAll("\\s+", "");
        Matcher matcher1 = pattern.matcher(complex1);
        Matcher matcher2 = pattern.matcher(complex2);
        if (!matcher1.matches() || !matcher2.matches()) {
            throw new IllegalArgumentException("Input is incorrect.");
        }
        int[] c1 = {Integer.parseInt(matcher1.group(1)), Integer.parseInt(matcher1.group(2))};
        int[] c2 = {Integer.parseInt(matcher2.group(1)), Integer.parseInt(matcher2.group(2))};
        String result = (c1[0] * c2[0] - c1[1] * c2[1]) + "" + (c1[0] * c2[1] + c1[1] * c2[0]) + "i";
        return result.replaceAll("([+\\-])", " $1 ");
    }

    @Test
    public void test1() {
        String multiply = complexMultiply("2 + 3i", "1 - 6i");
        System.out.println("multiply = " + multiply);
    }
}
