/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_26;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-26 23:03:40
 */
public class GenericTest {

    /**
     * max sub length
     *
     * @author lf
     * @time 2020-02-26 23:14:05
     * @param inputs inputs
     * @return int
     */
    private int maxSubLength(List<String> inputs) {
        int max = -1;
        int count = 0;
        for (int i = 0; i < inputs.size(); i++) {
            String currentValue = inputs.get(i);
            for (int j = 0; j < currentValue.length(); j++) {
                for (int k = j; k < currentValue.length(); k++) {
                    String current = currentValue.substring(j, k + 1);
                    count++;
                    if (validate(inputs, i, current)) {
                        max = Math.max(max, current.length());
                    }
                }
            }
        }
        System.out.println("count = " + count);
        return max;
    }

    /**
     * validate
     *
     * @author lf
     * @time 2020-02-26 23:10:32
     * @param list list
     * @param escapeIndex escape index
     * @param target target
     * @return boolean
     */
    private boolean validate(List<String> list, int escapeIndex, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (i == escapeIndex) {
                continue;
            }
            if (list.get(i).contains(target)) {
                return false;
            }
        }
        return true;
    }

    /**
     * max sub length
     *
     * @author lf
     * @time 2020-02-26 23:15:16
     * @param inputs inputs
     * @return int
     */
    private int maxSubLength(String... inputs) {
        List<String> list = Arrays.asList(inputs);
        return maxSubLength(list);
    }

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        int subLength = maxSubLength("aba", "cdc", "eae");
        System.out.println("subLength = " + subLength);
        System.out.println("cost " + (System.currentTimeMillis() - start) + "ms");
    }
}
