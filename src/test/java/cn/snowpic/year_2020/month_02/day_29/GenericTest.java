/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_29;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-29 11:15:11
 */
public class GenericTest {

    /**
     * minimum steps
     *
     * @author lf
     * @time 2020-02-29 14:16:04
     * @param input1 input1
     * @param input2 input2
     * @return int
     */
    private int minimumSteps(String input1, String input2) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input1.length(); i++) {
            for (int j = i + 1; j <= input1.length(); j++) {
                String current = input1.substring(i, j);
                if (input2.contains(current)) {
                    min = Math.min(min, input1.length() + input2.length() - 2 * current.length());
                }
            }
        }
        return min;
    }

    @Test
    public void test1() {
        int steps = minimumSteps("eat", "tea");
        System.out.println("steps = " + steps);
    }

    /**
     * duplicated files
     *
     * @author lf
     * @time 2020-02-29 17:20:02
     * @param inputs inputs
     * @return String[]
     */
    private List<Set<String>> duplicatedFiles(String... inputs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String input : inputs) {
            String[] split = input.split("\\s+");
            for (int i = 1; i < split.length; i++) {
                String key = split[i].replaceAll(".*(\\(.*\\))", "$1");
                Set<String> list = map.get(key);
                list = list == null ? new HashSet<>() : list;
                list.add(split[0] + "/" + split[i].substring(0, split[i].indexOf("(")));
                map.put(key, list);
            }
        }
        return map.values().stream()
                .filter(list -> list.size() > 1)
                .collect(Collectors.toList());
    }

    @Test
    public void test2() {
        List<Set<String>> files = duplicatedFiles("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)");
        System.out.println("files = " + files);
    }
}
