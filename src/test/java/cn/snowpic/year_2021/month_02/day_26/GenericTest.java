package cn.snowpic.year_2021.month_02.day_26;

import org.junit.Test;

import java.util.ArrayList;
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
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return result.stream().distinct().sorted((s1, s2) -> {
            int index = 0, c = 0;
            while (index < 3 && (c = s1.get(index).compareTo(s2.get(index))) == 0) {
                index++;
            }
            return -c;
        }).collect(Collectors.toList());
    }

    private void dfs(int[] nums, List<Integer> curr, boolean[] used) {
        if (curr.size() == 3) {
            Collections.sort(curr);
            if (curr.stream().mapToInt(Integer::intValue).sum() == 0) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            dfs(nums, curr, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
