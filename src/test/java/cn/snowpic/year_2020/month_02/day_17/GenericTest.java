/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-17 09:53:12
 */
public class GenericTest {

    /**
     * back tack
     *
     * @author lf
     * @time 2020-02-17 13:43:24
     * @param result result
     * @param tep tep
     * @param left left
     * @param right right
     * @param max max
     */
    private void backTack(List<String> result, String tep, int left, int right, int max) {
        if (tep.length() == 2 * max) {
            if (validate(tep)) {
                result.add(tep);
            }
            return;
        }
        if (left < max) {
            backTack(result, tep + "(", left + 1, right, max);
        }
        if (right < max) {
            backTack(result, tep + ")", left, right + 1, max);
        }
    }

    /**
     * generate
     *
     * @author lf
     * @time 2020-02-17 13:43:18
     * @param n n
     * @return @List<String>
     */
    private List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        backTack(result, "", 0, 0, n);
        return result;
    }

    /**
     * validate
     *
     * @author lf
     * @time 2020-02-17 13:43:12
     * @param str str
     * @return boolean
     */
    private boolean validate(String str) {
        int counter = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (--counter < 0) {
                return false;
            }
        }
        return counter == 0;
    }

    @Test
    public void test1() {
        List<String> generated = generate(10);
        System.out.println("generated = " + generated);
    }
}
