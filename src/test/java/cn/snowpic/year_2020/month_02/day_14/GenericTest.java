/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_14;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-14 12:21:16
 */
public class GenericTest {

    /**
     * translate with 2 exchanged chars
     *
     * @author lf
     * @time 2020-02-14 12:22:44
     * @param input1 input1
     * @param input2 input2
     * @return boolean
     */
    private boolean translateWith2ExchangedChars(String input1, String input2) {
        if (StringUtils.isBlank(input1) || StringUtils.isBlank(input2) || input1.length() != input2.length()) {
            return false;
        }
        if (input1.equals(input2)) {
            for (int i = 0; i < input1.length(); i++) {
                char current = input1.charAt(i);
                if (input1.lastIndexOf(current) != i) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < input1.length(); i++) {
                if (input1.charAt(i) != input2.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return input1.charAt(first) == input2.charAt(second)
                    && input1.charAt(second) == input2.charAt(first);
        }
    }

    @Test
    public void test1() {
        boolean translated = translateWith2ExchangedChars("ab", "ba");
        System.out.println("translated = " + translated);

        boolean translated1 = translateWith2ExchangedChars("ab", "ab");
        System.out.println("translated1 = " + translated1);
    }
}
