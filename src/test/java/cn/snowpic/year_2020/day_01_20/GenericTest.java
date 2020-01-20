/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_20;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * generic test
 * @className GenericTest
 *
 * @author lf
 * @time 2020-01-20 0:47
 */
public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-20 0:31
     */
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        List<String> vampire = vampire();
        System.out.println("vampire = " + vampire);
        System.out.println("cost " + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * vampire
     *
     * @author lf
     * @time 2020-01-20 0:43
     * @return @List<String>
     */
    private List<String> vampire() {
        List<String> result = new ArrayList<>();

        solution:
        for (int number = 1000; number < 10000; number++) {
            int tep = number;
            int[] array = new int[4];
            int index = 0;
            do {
                array[index++] = tep % 10;
                tep /= 10;
            } while (tep > 0);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == i) continue;
                    for (int k = 0; k < 4; k++) {
                        if (k == i || k == j) continue;
                        for (int m = 0; m < 4; m++) {
                            if (m == i || m == j || m == k) continue;
                            int a = array[i];
                            int b = array[j];
                            int c = array[k];
                            int d = array[m];
                            if (a == 0 || c == 0 || (b == 0 && d == 0)) continue;
                            int o = a * 10 + b;
                            int p = c * 10 + d;
                            if (number == o * p) {
                                String format = String.format("%s = %s * %s", number, o, p);
                                result.add(format);
                                continue solution;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * permute
     *
     * @author lf
     * @time 2020-01-20 20:39
     * @param origin origin
     * @param step step
     * @param tepContainer tep container
     * @param book book
     * @param result result
     */
    private void permute(final List<Integer> origin, int step, List<Integer> tepContainer, Set<Integer> book, List<List<Integer>> result) {
        // whether there a compete number permute
        if (tepContainer.size() == step) {
            // put current permute into the result
            result.add(new ArrayList<>(tepContainer));
            // return last node to find another chance
            return;
        }
        // traverse the origin
        for (int i = 0; i < origin.size(); i++) {
            // whether the index was marked
            if (book.add(i)) {
                // get current value
                Integer currentValue = origin.get(i);
                // add current value to the tep container
                tepContainer.add(currentValue);
                // recursive the method to find the next value index
                permute(origin, step, tepContainer, book, result);
                // remove the mark when call back
                book.remove(i);
                // remove the current value from the tep container
                tepContainer.remove(currentValue);
            }
        }
    }

    /**
     * permute
     *
     * @author lf
     * @time 2020-01-20 20:49
     * @param origin origin
     * @param step step
     * @return @List<List<Integer>>
     */
    private List<List<Integer>> permute(int[] origin, int step) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> collected = Arrays.stream(origin).boxed().collect(Collectors.toList());
        permute(collected, step, new ArrayList<>(), new HashSet<>(), result);
        return result;
    }

    @Test
    public void test2() {
        List<String> vampire = vampire(true);
        System.out.println("vampire = " + vampire);
    }

    /**
     * vampire
     *
     * @author lf
     * @time 2020-01-20 21:19
     * @param flag flag
     * @return @List<String>
     */
    private List<String> vampire(boolean flag) {
        if (flag) {
            System.out.println("This is a new method.");
        }
        List<String> result = new ArrayList<>();
        xxnb:
        for (int i = 1000; i < 10000; i++) {
            int tep = i;
            int[] array = new int[4];
            int index = 0;
            do {
                array[index++] = tep % 10;
                tep /= 10;
            } while (tep > 0);
            List<List<Integer>> permutes = permute(array, 4).stream()
                    // filter index 0, 1 can't be zero, index 2, 3 can't be zero concurrently
                    .filter(p -> (!p.get(0).equals(0) && !p.get(2).equals(0)) && !(p.get(1).equals(0) && p.get(3).equals(0)))
                    .collect(Collectors.toList());
            for (List<Integer> permute : permutes) {
                int a = permute.get(0) * 10 + permute.get(1);
                int b = permute.get(2) * 10 + permute.get(3);
                if (i == a * b) {
                    String format = String.format("%s = %s * %s", i, a, b);
                    result.add(format);
                    continue xxnb;
                }
            }
        }
        return result;
    }
}
