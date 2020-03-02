/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_02;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
}