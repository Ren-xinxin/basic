/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_16;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class GenericTest {

    /**
     * parse int
     *
     * @author lf
     * @time 2020-02-16 16:07:45
     * @param input input
     * @return int
     */
    private int parseInt(String input) {
        boolean negative = input.replaceAll("^([+-])", "$1").equals("-");
        String number = input.replaceAll("^([+-](\\d+)|\\d+)[^0-9]*.*", "$1");
        if (StringUtils.isBlank(number)) {
            return 0;
        }
        int value = Integer.parseInt(number);
        return negative ? -value : value;
    }

    @Test
    public void test1() {
        System.out.println(Integer.toString(Integer.MAX_VALUE, 10));
        System.out.println(Integer.toString(Integer.MIN_VALUE, 10));
        boolean negative = "-".replaceAll("^([+-])", "$1").equals("-");
        String number = "-12345ggg66".replaceAll("^([+-](\\d+)|(\\d+))([^0-9]+.*)?", "$2$3");
        System.out.println("negative = " + negative);
        System.out.println("number = " + number);
    }

    @Test
    public void test2() {
        String input = "-4193 with words";
        System.out.println(parseInt(input));
    }
}
