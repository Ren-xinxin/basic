/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_31;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * generic test
 *
 * @className GenericTest
 * @author Little Flower
 * @date 2020-03-31 21:41:28
 */
public class GenericTest {

    /**
     * filter
     *
     * @author Little Flower
     * @date 2020-04-01 21:53:17
     * @param inputs inputs
     * @param pattern pattern
     * @return String[]
     */
    private String[] filter(String[] inputs, String pattern) {
        return Arrays.stream(inputs)
                .filter(input -> {
                    if (input.length() != pattern.length()) {
                        return false;
                    }
                    // calculate a suitable capacity
                    int len = (int) Math.ceil(pattern.length() / 0.75f);
                    int capacity = 1;
                    while (capacity < len) {
                        capacity <<= 1;
                    }
                    Map<Character, Character> map = new HashMap<>(capacity);
                    for (int i = 0; i < pattern.length(); i++) {
                        Character key = pattern.charAt(i);
                        Character excepted = input.charAt(i);
                        Character value = map.get(key);
                        if (value == null && !map.containsValue(excepted)) {
                            map.put(key, excepted);
                            continue;
                        }
                        if (value != excepted) {
                            return false;
                        }
                    }
                    return true;
                })
                .toArray(String[]::new);
    }

    @Test
    public void test1() {
        String[] inputs = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        String[] filter = filter(inputs, pattern);
        System.out.println("filter = " + Arrays.toString(filter));
    }
}
