/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.month_02.day_02;

import org.junit.Test;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-02-02 21:33:25
     */
    @Test
    public void test1() {
        int index = index("hello", "ll1");
        System.out.println("index = " + index);
    }

    /**
     * index
     *
     * @author lf
     * @time 2020-02-02 21:30:08
     * @param origin origin
     * @param target target
     * @return int
     */
    private int index(String origin, String target) {
        if (origin == null || target == null || origin.length() < target.length()) {
            return -1;
        }
        int len = target.length();
        for (int i = 0; i < origin.length(); i++) {
            int endIndex = i + len;
            if (endIndex > origin.length()) {
                return -1;
            }
            String current = origin.substring(i, endIndex);
            if (current.equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
