/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.month_01.day_29;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class GenericTest {

    /**
     * back tracking
     *
     * @author lf
     * @time 2020-01-29 22:40
     * @param candidates candidates
     * @param target target
     * @param start start
     * @param curr curr
     * @param result result
     */
    private void backTracking(int[] candidates, final int target, int start, List<Integer> curr, Set<List<Integer>> result) {
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                // pruning
                if (candidates[i] > target) {
                    continue;
                }
                curr.add(candidates[i]);
                backTracking(candidates, target - candidates[i], start + 1, curr, result);
                // remove the last element for another chance
                curr.remove(curr.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(curr).stream()
                    .sorted()
                    .collect(Collectors.toList()));
        }
    }

    /**
     * combination sum
     *
     * @author lf
     * @time 2020-01-29 22:46
     * @param array array
     * @param target target
     * @return @List<List<Integer>>
     */
    private List<List<Integer>> combinationSum(int[] array, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(array);
        backTracking(array, target, 0, new ArrayList<>(), result);
        return result.stream()
                .sorted(Comparator.comparing(Object::toString))
                .collect(Collectors.toList());
    }

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-29 23:01
     */
    @Test
    public void test1() {
        int[] array = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> combinationSum = combinationSum(array, 8);
        System.out.println("combinationSum = " + combinationSum);
    }

    /**
     * test2
     *
     * @author lf
     * @time 2020-01-29 23:01
     */
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        System.out.println("list = " + list.toString());
    }
}
