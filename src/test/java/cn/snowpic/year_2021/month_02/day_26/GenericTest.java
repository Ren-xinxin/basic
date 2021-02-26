package cn.snowpic.year_2021.month_02.day_26;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericTest {
    private List<List<Integer>> result;

    @Test
    public void test1() {
        System.out.println(findSumOfNums(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private List<List<Integer>> findSumOfNums(int[] nums) {
        result = new ArrayList<>();
        int[] container = new int[3];
        dfs(nums, container, 0, new boolean[nums.length]);
        return result.stream().distinct().sorted((s1, s2) -> {
            int index = 0, c = 0;
            while (index < 3 && (c = s1.get(index).compareTo(s2.get(index))) == 0) {
                index++;
            }
            return -c;
        }).collect(Collectors.toList());
    }

    private void dfs(int[] nums, int[] container, int len, boolean[] used) {
        if (len == 3) {
            if (Arrays.stream(container).sum() == 0) {
                result.add(Arrays.stream(container).sorted().boxed().collect(Collectors.toList()));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            container[len] = nums[i];
            dfs(nums, container, len + 1, used);
            used[i] = false;
        }
    }
}
