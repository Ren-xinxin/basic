/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_24;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericTest {

    @Test
    public void test1() {
        int[] disappearedNums = findAllDisappearedNums(new int[]{4, 3, 2, 7, 8, 2, 3, 1, 1, 4, 4});
        System.out.println(Arrays.toString(disappearedNums));

        int[] disappearedNums2 = findDisappearedNums(new int[]{4, 3, 2, 7, 8, 2, 3, 1,});
        System.out.println(Arrays.toString(disappearedNums2));
    }

    private int[] findAllDisappearedNums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).sorted().distinct().boxed().collect(Collectors.toList());
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int expected = i + 1;
            if (index >= list.size() || list.get(index) != expected) {
                result.add(expected);
            } else {
                index++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] findDisappearedNums(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
