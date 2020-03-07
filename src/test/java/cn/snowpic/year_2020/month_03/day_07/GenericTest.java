/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-03-07 09:53:34
 */
public class GenericTest {

    /**
     * get coordinates
     *
     * @author lf
     * @time 2020-03-07 10:38:08
     * @param input input
     * @return @List<String>
     */
    private List<String> getCoordinates(String input) {
        if (!input.matches("^\\(\\d{4,12}\\)$")) {
            throw new IllegalArgumentException("Argument's format is illegal.");
        }
        input = input.replaceAll("[()]", "");

        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder(input);
        for (int i = 1; i < input.length(); i++) {
            sb.insert(i, ',');
            String strOutside = sb.toString();
            if (isMatches(strOutside)) {
                result.add(strOutside);
            }
            String left = input.substring(0, i);
            String right = input.substring(i);
            List<String> added = addDot(left, right);
            result.addAll(added);
            sb.deleteCharAt(i);
        }

        return result.stream()
                .map(str -> ('(' + str + ')'))
                .collect(Collectors.toList());
    }

    /**
     * add dot
     *
     * @author lf
     * @time 2020-03-07 11:08:24
     * @param left left
     * @param right right
     * @return @List<String>
     */
    private List<String> addDot(String left, String right) {
        StringBuilder leftBuilder = new StringBuilder(left);
        List<String> leftList = new ArrayList<String>() {{
            add(left);
        }};
        for (int i = 1; i < left.length(); i++) {
            leftBuilder.insert(i, '.');
            leftList.add(leftBuilder.toString());
            leftBuilder.deleteCharAt(i);
        }
        StringBuilder rightBuilder = new StringBuilder(right);
        List<String> rightList = new ArrayList<String>() {{
            add(right);
        }};
        for (int i = 1; i < right.length(); i++) {
            rightBuilder.insert(i, '.');
            rightList.add(rightBuilder.toString());
            rightBuilder.deleteCharAt(i);
        }
        return descartes(leftList, rightList).stream()
                .filter(GenericTest::isMatches)
                .collect(Collectors.toList());
    }

    /**
     * descartes
     *
     * @author lf
     * @time 2020-03-07 11:03:27
     * @param left left
     * @param right right
     * @return @List<String>
     */
    private List<String> descartes(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        for (String l : left) {
            for (String r : right) {
                result.add(l + ',' + r);
            }
        }
        return result;
    }

    /**
     * is matches
     *
     * @author lf
     * @time 2020-03-07 10:40:51
     * @param origin origin
     * @return boolean
     */
    private static boolean isMatches(String origin) {
        return origin.matches("^(([1-9]\\d*|0)(\\.\\d*[1-9])?),(([1-9]\\d*|0)(\\.\\d*[1-9])?)$");
    }

    @Test
    public void test1() {
        String input = "(0123)";
        List<String> coordinates = getCoordinates(input);
        System.out.println("coordinates = " + coordinates);
    }

    /**
     * blur info
     *
     * @author lf
     * @time 2020-03-07 15:46:04
     * @param info info
     * @return String
     */
    private String blurInfo(String info) {
        info = info.replaceAll("[() ,\\-]", "").toLowerCase();
        if (!info.matches("^[a-z][a-z0-9_]*[a-z0-9_]@[a-z][a-z0-9_]*(\\.com|\\.cn|\\.com\\.cn)$")
                && !info.matches("^(\\d{2})?\\d{10}$")) {
            throw new IllegalArgumentException("Info format is illegal.");
        }
        if (info.contains("@")) {
            return info.replaceAll("^(.).*(.)(@.+)$", "$1*****$2$3");
        }
        String result = info.replaceAll("^.*(\\d{4})$", "*_*_$1");
        return info.matches("^\\d{12}$") ? "+-" + result : result;
    }

    @Test
    public void test2() {
        String info1 = "LeetCode@LeetCode.com";
        String blurred1 = blurInfo(info1);
        System.out.println("blurred1 = " + blurred1);

        String info2 = "1234(56)7890";
        String blurred2 = blurInfo(info2);
        System.out.println("blurred2 = " + blurred2);
    }

    @Test
    public void test3() {
        new RenXin().test((k, u, z) -> {
            System.out.println(k + u + z);
        });
    }
}

class RenXin {

    private int[] data = {2, 3, 4};

    void test(MyConsumer<Integer, Integer, Integer> action) {
        action.accept(data[0], data[1], data[2]);
    }
}

@FunctionalInterface
interface MyConsumer<T, U, Z> {
    void accept(T t, U u, Z z);
}