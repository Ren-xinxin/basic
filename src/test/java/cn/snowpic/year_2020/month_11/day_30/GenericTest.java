/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_30;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTest {

    @Test
    public void test1() {
        int pairs = findKDiffPairs(new int[]{3, 1, 4, 1, 5}, 2);
        System.out.println(pairs);
        int pairs1 = findKDiffPairs(new int[]{1, 2, 3, 4, 5}, 1);
        System.out.println(pairs1);
    }

    /**
     * find k diff pairs
     *
     * @author Little Flower
     * @date 2020-12-01 23:54:17
     * @param nums nums
     * @param k k
     * @return int
     */
    private int findKDiffPairs(int[] nums, int k) {
        int counter = 0;
        List<Integer> numList = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());
        for (Integer num : numList) {
            int target = num + k;
            if (numList.contains(target)) {
                counter++;
            }
        }

        return counter;
    }
}
