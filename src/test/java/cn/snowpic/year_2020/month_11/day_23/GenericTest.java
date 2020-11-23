/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_23;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findThirdMaxNum(new int[]{3, 2, 1}));
        System.out.println(findThirdMaxNum(new int[]{1, 2}));

        System.out.println(findThirdMaxNum2(new int[]{3, 2, 1}));
        System.out.println(findThirdMaxNum2(new int[]{1, 2}));
    }

    /**
     * find third max num
     *
     * @author Little Flower
     * @date 2020-11-23 21:32:04
     * @param nums nums
     * @return int
     */
    private int findThirdMaxNum(int[] nums) {
        List<Integer> resultList = Arrays.stream(nums).boxed().distinct().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return resultList.size() < 3 ? resultList.get(0) : resultList.get(2);
    }

    /**
     * find third max num2
     *
     * @author Little Flower
     * @date 2020-11-23 21:36:21
     * @param nums nums
     * @return int
     */
    private int findThirdMaxNum2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int num : nums) {
            if (num == max) {
                continue;
            }
            second = Math.max(second, num);
        }
        for (int num : nums) {
            if (num == max || num == second) {
                continue;
            }
            third = Math.max(third, num);
        }
        return third == Integer.MIN_VALUE ? max : third;
    }
}
