/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.month_01.day_18;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
            if (value % min != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * test3
     *
     * @author lf
     * @time 2020-01-18 20:53
     */
    @Test
    public void test3() {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> numbers = zeroSumOfThreeNumbers(array);
        System.out.println("numbers = " + numbers);
    }

    /**
     * zero sum of three numbers
     *
     * @author lf
     * @time 2020-01-18 20:54
     * @param array array
     * @return @Set<List<Integer>>
     */
    private Set<List<Integer>> zeroSumOfThreeNumbers(int[] array) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        ArrayList<Integer> origin = new ArrayList<>();
                        origin.add(array[i]);
                        origin.add(array[j]);
                        origin.add(array[k]);
                        List<Integer> sorted = origin.stream()
                                .sorted()
                                .collect(Collectors.toList());
                        result.add(sorted);
                    }
                }
            }
        }
        return result;
    }

    /**
     * test4
     *
     * @author lf
     * @time 2020-01-18 23:33
     */
    @Test
    public void test4() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(2);
            add(8);
            add(6);
            add(5);
        }};

        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}