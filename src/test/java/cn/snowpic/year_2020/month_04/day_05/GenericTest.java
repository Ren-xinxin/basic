/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_05;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author Little Flower
 * @date 2020-04-05 19:45:24
 */
public class GenericTest {

    /**
     * validate number
     *
     * @author Little Flower
     * @date 2020-04-05 19:52:39
     * @param input input
     * @return boolean
     */
    private boolean validateNumber(String input) {
        return input != null && input.matches("^0|([1-9]\\d|0)*\\.\\d*[1-9]|[1-9]\\d*e[1-9]\\d*$");
    }

    @Test
    public void test1() {
        System.out.println(validateNumber("0"));
        System.out.println(validateNumber("0.1"));
        System.out.println(validateNumber("abc"));
        System.out.println(validateNumber("2e10"));
    }
}
