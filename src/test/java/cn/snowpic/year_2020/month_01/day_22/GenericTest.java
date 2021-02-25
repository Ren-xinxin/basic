/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.day_22;

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
        Set<List<Integer>> permutes = CommonUtils.permute(array, 3);
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
        Set<List<Integer>> permutes = CommonUtils.permute(array, 4);
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

    /**
     * next larger permute
     *
     * @author lf
     * @time 2020-01-22 21:30
     * @param array array
     * @return int[]
     */
    private int[] nextLargerPermute(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                int tep = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tep;
                return array;
            }
        }
        Arrays.sort(array);
        return array;
    }

    /**
     * test3
     *
     * @author lf
     * @time 2020-01-22 21:32
     */
    @Test
    public void test3() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {3, 2, 1};
        int[] array3 = {1, 1, 5};

        int[] nextLargerPermute1 = nextLargerPermute(array1);
        int[] nextLargerPermute2 = nextLargerPermute(array2);
        int[] nextLargerPermute3 = nextLargerPermute(array3);

        System.out.println("nextLargerPermute1 = " + Arrays.toString(nextLargerPermute1));
        System.out.println("nextLargerPermute2 = " + Arrays.toString(nextLargerPermute2));
        System.out.println("nextLargerPermute3 = " + Arrays.toString(nextLargerPermute3));
    }

    /**
     * find index
     *
     * @author lf
     * @time 2020-01-22 21:47
     * @param array array
     * @param target target
     * @return int
     */
    private int findIndex(int[] array, int target) {
        //Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test4() {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int index = findIndex(array, 0);
        System.out.println("index = " + index);
    }
}
