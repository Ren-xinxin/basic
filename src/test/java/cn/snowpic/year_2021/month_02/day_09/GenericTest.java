/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_09;

import org.junit.Test;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(getMinPrintTimes("RRRGR"));
        System.out.println(getMinPrintTimes("RRRGRGG"));
    }

    private int getMinPrintTimes(String road) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= road.length(); i++) {
            String left = road.substring(0, i);
            String right = road.substring(i);
            int temp = getInvalid(left, 'G') + getInvalid(right, 'R');
            min = Math.min(min, temp);
        }
        return min;
    }

    private int getInvalid(String str, char target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }
}
