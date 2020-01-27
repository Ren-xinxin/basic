/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_27;

import cn.snowpic.util.CommonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        List<List<Integer>> sum2 = findSum2(array, 7);
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
            List<List<Integer>> permutes = CommonUtils.permute(array, step);
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
     * find sum permute
     *
     * @author lf
     * @time 2020-01-28 1:35
     * @param target target
     * @param array array
     * @param index index
     * @param tepContainer tep container
     * @param result result
     */
    private void findSumPermute(final int target, List<Integer> array, int index, List<Integer> tepContainer, List<List<Integer>> result) {
        Integer currentElement = array.get(index);
        int currentSum = tepContainer.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int len = (target - currentSum) / currentElement;
        try {
            for (int i = 0; i < len; i++) {
                int newSum = currentSum + currentElement * (i + 1);
                tepContainer.add(currentElement);
                // whether the sum greater than target
                if (newSum >= target) {
                    if (newSum == target) {
                        result.add(tepContainer);
                    }
                    return;
                }
                // find next index's chance
                for (int j = index + 1; j < array.size(); j++) {
                    findSumPermute(target, array, i, tepContainer, result);
                }
            }
        } finally {
            // remove current element
            while (tepContainer.contains(currentElement)) {
                tepContainer.remove(currentElement);
            }
        }
    }

    private List<List<Integer>> findSum2(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> collect = Arrays.stream(array)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        List<List<Integer>> tep = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<List<Integer>> permutes = CommonUtils.permute(array, i + 1);
            tep.addAll(permutes.stream()
                    .filter(permute -> permute.stream()
                            .mapToInt(Integer::intValue)
                            .sum() <= target)
                    .collect(Collectors.toList()));
        }
        findSumPermute(target, collect, 0, new ArrayList<>(), result);
        return result;
    }
}
