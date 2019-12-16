/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_12_15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/15 0:09
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/12/15 0:15
     */
    @Test
    public void test1() {
        int[] merge = merge(new int[]{2, 3, 4, 7, 7, 9}, new int[]{1, 1, 2, 3, 4, 5, 6, 6, 7, 7, 7});
        System.out.println("merge = " + Arrays.toString(merge));
    }

    /**
     * merge
     * @author lf
     * @time 2019/12/15 0:15
     * @param arrays1 arrays1
     * @param arrays2 arrays2
     * @return int[]
     */
    private int[] merge(int[] arrays1, int[] arrays2) {
        int[] result = new int[arrays1.length + arrays2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arrays1.length && j < arrays2.length) {
            if (arrays1[i] < arrays2[j]) {
                result[k++] = arrays1[i++];
            } else {
                result[k++] = arrays2[j++];
            }
        }
        if (i == arrays1.length) {
            while (j < arrays2.length) {
                result[k++] = arrays2[j++];
            }
        } else {
            while (i < arrays1.length) {
                result[k++] = arrays1[i++];
            }
        }
        return result;
    }

    /**
     * test2
     * @author lf
     * @time 2019/12/15 22:23
     */
    @Test
    public void test2() {
        int line = 10;
        List<List<Integer>> delta = delta(line);
        System.out.println("delta = " + delta);
        /*String s = delta.toString();
        String s1 = s.substring(1, s.length() - 2).replaceAll("\\s", "").replaceAll("\\[", "");
        String[] split = s1.split("],");
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < (line - 1 - i); j++) {
                System.out.print(" ");
            }
            System.out.println(split[i].replaceAll(",", " "));
        }*/
    }

    /**
     * delta
     * @author lf
     * @time 2019/12/15 22:23
     * @param line line
     * @return @List<List<Integer>>
     */
    public List<List<Integer>> delta(int line) {
        List<List<Integer>> result = new ArrayList<>(line);
        if (line < 1) {
            throw new IllegalArgumentException("line must greater than 0");
        }
        result.add(new ArrayList<Integer>() {{
            add(1);
        }});
        for (int i = 2; i <= line; i++) {
            List<Integer> child = new ArrayList<>();
            List<Integer> lastRow = result.get(i - 2);
            for (int j = 0; j < i; j++) {
                int value = (j - 1 < 0 ? 0 : lastRow.get(j - 1)) + (j == lastRow.size() ? 0 : lastRow.get(j));
                child.add(value);
            }
            result.add(child);
        }
        return result;
    }

}
