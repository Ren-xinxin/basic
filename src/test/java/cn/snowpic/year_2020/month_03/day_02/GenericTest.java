/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_02;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-03-02 09:31:39
 */
public class GenericTest {

    /**
     * delete comments
     *
     * @author lf
     * @time 2020-03-02 10:30:39
     * @param code code
     * @return @List<String>
     */
    private List<String> deleteComments(List<String> code) {
        List<Map<String, Boolean>> collect = code.stream()
                .map(c -> new HashMap<String, Boolean>() {{
                    put(c, Boolean.FALSE);
                }})
                .collect(Collectors.toList());
        // filter comments
        filterComments(collect);

        return collect.stream()
                .filter(GenericTest::filter)
                .map(GenericTest::translate)
                .collect(Collectors.toList());
    }

    /**
     * filter comments
     *
     * @author lf
     * @time 2020-03-02 10:30:34
     * @param collect collect
     */
    private void filterComments(List<Map<String, Boolean>> collect) {
        boolean flag = false;
        for (Map<String, Boolean> current : collect) {
            Map.Entry<String, Boolean> entry = current.entrySet().iterator().next();
            // trim every line
            String key = entry.getKey().trim();
            if (key.matches("^/\\*.*$")) {
                entry.setValue(Boolean.TRUE);
                flag = true;
                continue;
            } else if (key.matches("^.*\\*/$")) {
                entry.setValue(Boolean.TRUE);
                flag = false;
                continue;
            } else if (flag) {
                entry.setValue(Boolean.TRUE);
                continue;
            }
            if (key.matches("^//.*$")) {
                entry.setValue(Boolean.TRUE);
            }
        }
    }

    /**
     * filter
     *
     * @author lf
     * @time 2020-03-02 10:30:26
     * @param c c
     * @return boolean
     */
    private static boolean filter(Map<String, Boolean> c) {
        return !c.values().iterator().next();
    }

    /**
     * translate
     *
     * @author lf
     * @time 2020-03-02 10:30:20
     * @param c c
     * @return String
     */
    private static String translate(Map<String, Boolean> c) {
        return c.entrySet().iterator().next().getKey();
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("/*四大皆空手机打开手机", "这是块注释中间的", "注释结束啦*/", "//行内注释", "real code");
        List<String> deleteComments = deleteComments(list);
        System.out.println("deleteComments = " + deleteComments);
    }

    /**
     * split
     *
     * @author lf
     * @time 2020-03-02 14:23:25
     * @param input input
     * @return @List<String>
     */
    private List<String> split(String input) {
        int start = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String current = input.substring(start, i + 1);
            if (!contains(input, current, i)) {
                start = i + 1;
                result.add(current);
            }
        }
        return result;
    }

    /**
     * contains
     *
     * @author lf
     * @time 2020-03-02 14:09:46
     * @param input input
     * @param current current
     * @param index index
     * @return boolean
     */
    private boolean contains(String input, String current, int index) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < current.length(); i++) {
            set.add(current.charAt(i));
        }
        Iterator<Character> iterator = set.iterator();
        String last = index + 1 > input.length() - 1 ? "" : input.substring(index + 1);
        while (iterator.hasNext()) {
            Character next = iterator.next();
            if (last.contains(String.valueOf(next))) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test2() {
        String input = "ababcbacadefegdehijhklij";
        List<String> split = split(input);
        System.out.println("split = " + split);
    }
}