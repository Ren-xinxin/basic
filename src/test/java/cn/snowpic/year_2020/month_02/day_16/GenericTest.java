/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_16;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTest {

    /**
     * parse int
     *
     * @author lf
     * @time 2020-02-16 16:07:45
     * @param input input
     * @return int
     */
    private int parseInt(String input) {
        boolean negative = input.replaceAll("^([+-])", "$1").equals("-");
        String number = input.replaceAll("^([+-](\\d+)|\\d+)[^0-9]*.*", "$1");
        if (StringUtils.isBlank(number)) {
            return 0;
        }
        int value = Integer.parseInt(number);
        return negative ? -value : value;
    }

    @Test
    public void test1() {
        System.out.println(Integer.toString(Integer.MAX_VALUE, 10));
        System.out.println(Integer.toString(Integer.MIN_VALUE, 10));
        boolean negative = "-".replaceAll("^([+-])", "$1").equals("-");
        String number = "-12345ggg66".replaceAll("^([+-](\\d+)|(\\d+))([^0-9]+.*)?", "$2$3");
        System.out.println("negative = " + negative);
        System.out.println("number = " + number);
    }

    @Test
    public void test2() {
        String input = "-4193 with words";
        System.out.println(parseInt(input));
    }

    /**
     * combine
     *
     * @author lf
     * @time 2020-02-16 20:15:07
     * @param origin origin
     * @param index index
     * @param prefix prefix
     * @param maps maps
     * @param result result
     */
    private void combine(String origin, int index, String prefix, Map<Character, String> maps, List<String> result) {
        char charAt = origin.charAt(index);
        String current = maps.get(charAt);
        for (int i = 0; i < current.length(); i++) {
            if (index == origin.length() - 1) {
                result.add(prefix + current.charAt(i));
            } else {
                combine(origin, index + 1, prefix + current.charAt(i), maps, result);
            }
        }
    }

    /**
     * combine
     *
     * @author lf
     * @time 2020-02-16 20:15:16
     * @param input input
     * @return @List<String>
     */
    private List<String> combine(String input) {
        Map<Character, String> maps = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tvu");
                put('9', "wxyz");
            }
        };
        List<String> result = new ArrayList<>();
        combine(input, 0, "", maps, result);
        return result;
    }

    @Test
    public void test3() {
        List<String> combine = combine("23");
        System.out.println("combine = " + combine);
    }

}
