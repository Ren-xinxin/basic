/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_29;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-29 11:15:11
 */
public class GenericTest {

    /**
     * minimum steps
     *
     * @author lf
     * @time 2020-02-29 14:16:04
     * @param input1 input1
     * @param input2 input2
     * @return int
     */
    private int minimumSteps(String input1, String input2) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input1.length(); i++) {
            for (int j = i + 1; j <= input1.length(); j++) {
                String current = input1.substring(i, j);
                if (input2.contains(current)) {
                    min = Math.min(min, input1.length() + input2.length() - 2 * current.length());
                }
            }
        }
        return min;
    }

    @Test
    public void test1() {
        int steps = minimumSteps("eat", "tea");
        System.out.println("steps = " + steps);
    }
}
