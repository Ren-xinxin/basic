/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.day_30;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-01-31 00:09:20
 */
public class GenericTest {

    @Test
    public void test1() {
        String[] inputs1 = {"flower", "flow", "flight"};
        String commonPrefix1 = findCommonPrefix(inputs1);
        System.out.println("commonPrefix1 = " + commonPrefix1);
    }

    /**
     * find common prefix
     *
     * @author lf
     * @time 2020-01-31 00:09:09
     * @param inputs inputs
     * @return String
     */
    private String findCommonPrefix(String[] inputs) {
        String result = null;
        for (String input : inputs) {
            if (result == null) {
                result = input;
            }
            int len = Math.min(result.length(), input.length());
            result = result.substring(0, len);
            for (int i = 0; i < len; i++) {
                if (result.charAt(i) != input.charAt(i)) {
                    result = result.substring(0, i);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * test2
     *
     * @author lf
     * @time 2020-01-31 00:20:02
     */
    @Test
    public void test2() {
        System.out.println("k".substring(0, 0));
    }
}
