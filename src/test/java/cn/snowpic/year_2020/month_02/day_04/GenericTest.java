/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_04;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-04 23:04:04
 */
public class GenericTest {

    @Test
    public void test1() {
        int len = lastWordLen("Hello World");
        System.out.println("len = " + len);
    }

    /**
     * last word len
     *
     * @author lf
     * @time 2020-02-04 23:07:50
     * @param sentence sentence
     * @return int
     */
    private int lastWordLen(String sentence) {
        sentence = sentence.trim();
        int len = sentence.length();
        for (int length = sentence.length() - 1; length >= 0; length--) {
            if (sentence.charAt(length) == ' ') {
                return len - length - 1;
            }
        }
        return 0;
    }
}
