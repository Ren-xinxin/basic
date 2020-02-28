/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_28;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-28 20:08:38
 */
public class GenericTest {

    /**
     * optimal division
     *
     * @author lf
     * @time 2020-02-28 20:41:49
     * @param numbers numbers
     * @return String
     */
    public String optimalDivision(int[] numbers) {
        StringJoiner sj = new StringJoiner("/");
        for (int i = 1; i < numbers.length; i++) {
            sj.add(numbers[i] + "");
        }
        return String.format("%d/(%s)", numbers[0], sj.toString());
    }

    @Test
    public void test1() {
        int[] array = {5, 8, 2};
        String division = optimalDivision(array);
        System.out.println("division = " + division);
    }
}
