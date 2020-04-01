/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_01;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericTest {

    /**
     * filter
     *
     * @author Little Flower
     * @date 2020-04-01 23:00:26
     * @param words words
     * @param subs subs
     * @return String[]
     */
    private String[] filter(String[] words, String[] subs) {
        List<Map<Character, Integer>> subRules = Arrays.stream(subs)
                .map(this::group)
                .collect(Collectors.toList());
        return Arrays.stream(words)
                .filter(word -> !matches(subRules, word))
                .toArray(String[]::new);
    }

    /**
     * matches
     *
     * @author Little Flower
     * @date 2020-04-01 23:00:09
     * @param subRules sub rules
     * @param word word
     * @return boolean
     */
    private boolean matches(List<Map<Character, Integer>> subRules, String word) {
        Map<Character, Integer> grouped = group(word);
        for (Map<Character, Integer> currRule : subRules) {
            Set<Character> keySet = currRule.keySet();
            for (Character key : keySet) {
                Integer exceptedCount = currRule.get(key);
                Integer currCount = grouped.get(key);
                if (currCount == null || currCount < exceptedCount) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * group
     *
     * @author Little Flower
     * @date 2020-04-01 22:46:30
     * @param sub sub
     * @return Map<Integer>
     */
    private Map<Character, Integer> group(String sub) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            Character key = sub.charAt(i);
            Integer value = map.getOrDefault(key, 0);
            map.put(key, value + 1);
        }
        return map;
    }

    @Test
    public void test1() {
        String[] words = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] subs = {"e", "o"};
        String[] filter = filter(words, subs);
        System.out.println("filter = " + Arrays.toString(filter));
    }
}
