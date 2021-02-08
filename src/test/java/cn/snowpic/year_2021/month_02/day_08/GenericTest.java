/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_08;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(calcExpression("1+2+3-4"));
        System.out.println(calcExpression("1+2+3-5"));
    }

    private int calcExpression(String expression) {
        return Arrays.stream(expression
                .replaceAll("[ ]+", "")
                .replaceAll("-", "+-")
                .split("\\+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
