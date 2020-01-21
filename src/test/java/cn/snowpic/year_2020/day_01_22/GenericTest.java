/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_22;

import cn.snowpic.util.CommonUtils;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
}
