/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_27;

import org.junit.Test;

import java.util.Arrays;
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

    /**
     * minimum minutes
     *
     * @author lf
     * @time 2020-02-27 23:06:55
     * @param inputs inputs
     * @return int
     */
    private int minimumMinutes(String... inputs) {
        String display = Arrays.toString(inputs).replaceAll("\\s+", "");
        if (!display.matches("^\\[(\\d{2}:\\d{2})(,\\d{2}:\\d{2}){1,9}]$")) {
            throw new IllegalArgumentException("Input is incorrect.");
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < inputs.length - 1; i++) {
            for (int j = i + 1; j < inputs.length; j++) {
                int one = parseMinutes(inputs[i]);
                int another = parseMinutes(inputs[j]);
                int abs = Math.abs(one - another);
                // update minimum value
                min = Math.min(min, Math.min(abs, 24 * 60 - abs));
            }
        }
        return min;
    }

    /**
     * parse minutes
     *
     * @author lf
     * @time 2020-02-27 22:59:13
     * @param time time
     * @return int
     */
    private int parseMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0].trim()) * 60 + Integer.parseInt(split[1].trim());
    }

    @Test
    public void test2() {
        int min = minimumMinutes("23:59", "00:00");
        System.out.println("min = " + min);
    }
}
