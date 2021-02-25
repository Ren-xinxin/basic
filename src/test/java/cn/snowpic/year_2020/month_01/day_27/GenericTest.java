/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.day_27;

import cn.snowpic.util.CommonUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-27 11:41
     */
    @Test
    public void test1() {
        int[] array = {5, 7, 8, 8, 10};
        int[] range1 = findRange(array, 8);
        int[] range2 = findRange(array, 6);

        System.out.println("range2 = " + Arrays.toString(range1));
        System.out.println("range2 = " + Arrays.toString(range2));
    }

    /**
     * find range
     *
     * @author lf
     * @time 2020-01-27 11:46
     * @param array array
     * @param target target
     * @return int[]
     */
    private int[] findRange(int[] array, int target) {
        int[] result = {-1, -1};
        boolean isStart = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                if (isStart) {
                    isStart = false;
                    result[0] = i + 1;
                }
                result[1] = i + 1;
            }
        }
        return result;
    }

    @Test
    public void test2() {
        int[] array = {2, 3, 6, 7};
        List<List<Integer>> sum = findSum(array, 7);
        System.out.println("sum = " + sum);

        Set<List<Integer>> sum2 = findSum2(array, 7);
        System.out.println("sum2 = " + sum2);
    }

    /**
     * find sum
     *
     * @author lf
     * @time 2020-01-27 12:13
     * @param array array
     * @param target target
     * @return @List<List<Integer>>
     */
    private List<List<Integer>> findSum(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int step = 1; step < array.length + 1; step++) {
            Set<List<Integer>> permutes = CommonUtils.permute(array, step);
            permutes.forEach(permute -> {
                int sum = permute.stream()
                        .mapToInt(Integer::intValue)
                        .sum();
                if (target == sum) {
                    List<Integer> list = permute.stream()
                            .sorted()
                            .collect(Collectors.toList());
                    result.add(list);
                }
            });
        }
        return result;
    }

    /**
     * find sum2
     *
     * @author lf
     * @time 2020-01-28 23:28
     * @param array array
     * @param target target
     * @return @Set<List<Integer>>
     */
    private Set<List<Integer>> findSum2(int[] array, int target) {
        Set<List<Integer>> result = new HashSet<>();
        array = Arrays.stream(array).sorted().distinct().toArray();
        backTracking(array, target, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * back tracking
     *
     * @author lf
     * @time 2020-01-28 23:25
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
                backTracking(candidates, target - candidates[i], start, curr, result);
                // remove the last element for another chance
                curr.remove(curr.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(curr).stream()
                    .sorted()
                    .collect(Collectors.toList()));
        }
    }
}
