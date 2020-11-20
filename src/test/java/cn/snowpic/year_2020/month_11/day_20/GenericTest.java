/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_20;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findDuplicates(new int[]{1, 2, 3, 1}, 3));
        System.out.println(findDuplicates(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private boolean findDuplicates(int[] array, int distance) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            List<Integer> indices = map.get(key);
            if (indices == null) {
                indices = new ArrayList<>();
            }
            indices.add(i);
            map.put(key, indices);
        }
        List<List<Integer>> duplicatedIndices = map.values().stream().filter(m -> (m != null && m.size() > 1))
                .collect(Collectors.toList());
        for (List<Integer> indices : duplicatedIndices) {
            for (Integer index : indices) {
                int len = distance + index;
                if (len < array.length) {
                    if (indices.contains(len)) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
