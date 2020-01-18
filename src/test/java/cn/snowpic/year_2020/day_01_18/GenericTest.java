/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_18;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * generic test
 * @className GenericTest
 *
 * @author lf
 * @time 2020-01-18 0:10
 */
public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-18 0:10
     */
    @Test
    public void test1() {
        int[] array = {3, 1, 2, 4};
        int[] parity = sortArrayByParity(array);
        System.out.println("parity = " + Arrays.toString(parity));
    }

    /**
     * sort array by parity
     *
     * @author lf
     * @time 2020-01-18 0:09
     * @param array array
     * @return int[]
     */
    private int[] sortArrayByParity(int[] array) {
        int[] result = new int[array.length];
        int head = 0;
        int tail = array.length - 1;
        for (int i : array) {
            if (i % 2 == 0) {
                result[head++] = i;
            } else {
                result[tail--] = i;
            }
        }
        return result;
    }

    /**
     * test2
     *
     * @author lf
     * @time 2020-01-18 16:01
     */
    @Test
    public void test2() {
        int[] cards1 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] cards2 = {1, 1, 2, 2, 2, 2};
        boolean sortCards1 = sortCards(cards1);
        boolean sortCards2 = sortCards(cards2);
        System.out.println("sortCards1 = " + sortCards1);
        System.out.println("sortCards2 = " + sortCards2);

        int[] cards3 = {1};
        boolean sortCards3 = sortCards(cards3);
        System.out.println("sortCards3 = " + sortCards3);
    }

    /**
     * sort cards
     *
     * @author lf
     * @time 2020-01-18 17:11
     * @param cards cards
     * @return boolean
     */
    private boolean sortCards(int[] cards) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int card : cards) {
            Integer cardCount = counter.get(card);
            counter.put(card, cardCount == null ? 1 : ++cardCount);
        }
        Integer min = counter.values().stream().min(Integer::compareTo).orElse(-1);
        if (min < 2) {
            return false;
        }
        for (Integer value : counter.values()) {
            if (!value.equals(min) && value % min != 0) {
                return false;
            }
        }
        return true;
    }
}