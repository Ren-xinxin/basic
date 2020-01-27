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
        for (int i = 0; i < array.length; i++) {
            List<List<Integer>> permutes = CommonUtils.permute(array, i + 1);
            permutes.forEach(permute -> {
                int sum = permute.stream().mapToInt(Integer::intValue).sum();
                if (target == sum) {
                    List<Integer> list = permute.stream().sorted().collect(Collectors.toList());
                    result.add(list);
                }
            });
        }
        return result;
    }
}
