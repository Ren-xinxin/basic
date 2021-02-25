/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.day_11;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * generic test
 * @className GenericTest
 * @author lf
 * @time 2020-01-11 14:03
 */
public class GenericTest {

    @Test
    public void test1() {
        int[][] toeplitz1 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        };
        boolean toeplitz = toeplitz(toeplitz1);
        System.out.println("toeplitz = " + toeplitz);
    }

    /**
     * toeplitz
     * @author lf
     * @time 2020-01-11 20:52
     * @param arrays arrays
     * @return boolean
     */
    private boolean toeplitz(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            if (isNotToeplitz(arrays, i, 0)) {
                return false;
            }
            if (i > 0) {
                continue;
            }
            for (int j = 1; j < arrays[i].length; j++) {
                if (isNotToeplitz(arrays, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * is toeplitz
     *
     * @author lf
     * @time 2020-01-11 21:11
     * @param arrays arrays
     * @param row row
     * @param column column
     * @return boolean
     */
    private boolean isNotToeplitz(int[][] arrays, int row, int column) {
        int sameVal;
        sameVal = arrays[row][column];
        int tepI = row;
        int tepJ = column;
        while (++tepI < arrays.length && ++tepJ < arrays[row].length) {
            if (arrays[tepI][tepJ] != sameVal) {
                return true;
            }
        }
        return false;
    }

    /**
     * test2
     *
     * @author lf
     * @time 2020-01-11 23:20
     */
    @Test
    public void test2() {
        String[] inputs = {"9001 discuss.leetcode.com"};
        Map<String, Integer> count = findSubDomainCount(inputs);
        System.out.println("count = " + count);

        String[] inputs2 = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        Map<String, Integer> count2 = findSubDomainCount(inputs2);
        System.out.println("count2 = " + count2);
    }

    /**
     * find sub domain count
     *
     * @author lf
     * @time 2020-01-11 22:58
     * @return @Map<Integer>
     */
    private Map<String, Integer> findSubDomainCount(String[] inputs) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String input : inputs) {
            String[] split = input.split(" ");
            String key = split[1];
            int baseCount = Integer.parseInt(split[0]);
            Integer oldCount = map.get(key);
            map.put(key, oldCount == null ? baseCount : baseCount + oldCount);
            int index = -1;
            while (true) {
                index = key.indexOf(".", index + 1);
                if (index == -1) {
                    break;
                }
                String nextDomain = key.substring(index + 1);
                Integer count = map.get(nextDomain);
                map.put(nextDomain, count == null ? baseCount : baseCount + count);
            }
        }
        return map;
    }
}
