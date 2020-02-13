/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.month_01.day_31;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-01-31 21:31:12
 */
public class GenericTest {

    @Test
    public void test1() {
        String rome = "MCMXCIV";
        int romeToNumber = translateRomeToNumber(rome);
        System.out.println("romeToNumber = " + romeToNumber);
    }

    /**
     * translate rome to number
     *
     * @author lf
     * @time 2020-01-31 21:32:27
     * @param rome rome
     * @return int
     */
    private int translateRomeToNumber(String rome) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result = 0;
        for (int i = 0; i < rome.length(); i++) {
            if (i > 0 && map.get(rome.charAt(i)) > map.get(rome.charAt(i - 1))) {
                // artifact...
                result += map.get(rome.charAt(i)) - 2 * map.get(rome.charAt(i - 1));
            } else {
                result += map.get(rome.charAt(i));
            }
        }
        return (result == 0) ? -1 : result;
    }
}
