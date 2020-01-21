/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_22;

import cn.snowpic.util.CommonUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * generic test
 * @className GenericTest
 *
 * @author lf
 * @time 2020-01-22 0:24
 */
public class GenericTest {

    @Test
    public void test1() {
        int[] array = {-1, 2, 1, -4};
        int closestThreeNums = findClosestThreeNums(array, 1);
        System.out.println("closestThreeNums = " + closestThreeNums);
    }

    /**
     * find closest three nums
     *
     * @author lf
     * @time 2020-01-22 0:15
     * @param array array
     * @param target target
     * @return int
     */
    private int findClosestThreeNums(int[] array, int target) {
        AtomicInteger result = new AtomicInteger(Integer.MAX_VALUE);
        List<List<Integer>> permutes = CommonUtils.permute(array, 3);
        permutes.forEach(permute -> {
            int sum = permute.stream().mapToInt(Integer::intValue).sum();
            if ((Math.abs(sum - target) < Math.abs(target - result.get()))) {
                result.set(sum);
            }
        });
        return result.get();
    }

    /**
     * find four numbers sum
     *
     * @author lf
     * @time 2020-01-22 0:23
     * @param array array
     * @param target target
     * @return @Set<List<Integer>>
     */
    private Set<List<Integer>> findFourNumbersSum(int[] array, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> permutes = CommonUtils.permute(array, 4);
        permutes.forEach(permute -> {
            List<Integer> element = permute.stream().sorted().collect(Collectors.toList());
            int sum = element.stream().mapToInt(Integer::intValue).sum();
            if (sum == target) {
                result.add(element);
            }
        });
        return result.stream()
                .sorted(Comparator.comparingInt(e -> Math.abs(e.get(0))))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Test
    public void test2() {
        int[] array = {1, 0, -1, 0, -2, 2};
        Set<List<Integer>> lists = findFourNumbersSum(array, 0);
        System.out.println("lists = " + lists);
    }
}
