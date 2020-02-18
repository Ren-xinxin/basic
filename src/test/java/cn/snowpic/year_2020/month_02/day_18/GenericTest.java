/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_18;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-18 22:51:10
 */
public class GenericTest {

    /**
     * group str
     *
     * @author lf
     * @time 2020-02-18 23:12:50
     * @param inputs inputs
     * @return @List<List<String>>
     */
    private List<List<String>> groupStr(String[] inputs) {
        Map<Set<Character>, List<String>> map = new HashMap<>();
        Arrays.stream(inputs)
                .forEach(str -> {
                    Set<Character> key = convert(str);
                    List<String> list = Optional.ofNullable(map.get(key)).orElse(new ArrayList<>());
                    list.add(str);
                    map.put(key, list);
                });
        return map.values().stream()
                .sorted(Comparator.comparing(l -> l.stream()
                        .sorted()
                        .collect(Collectors.toList())
                        .get(0)))
                .collect(Collectors.toList());
    }

    /**
     * convert
     *
     * @author lf
     * @time 2020-02-18 23:06:56
     * @param input input
     * @return @Set<Character>
     */
    private Set<Character> convert(String input) {
        Set<Character> result = new HashSet<>();
        for (char c : input.toCharArray()) {
            result.add(c);
        }
        return result;
    }

    @Test
    public void test1() {
        String[] inputs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> grouped = groupStr(inputs);
        System.out.println("grouped = " + grouped);
    }
}
