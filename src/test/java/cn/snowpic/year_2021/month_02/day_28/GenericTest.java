package cn.snowpic.year_2021.month_02.day_28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTest {
    private List<List<Integer>> result;

    private int target;

    @Test
    public void test1() {
        System.out.println(findSumOfFourNums(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    private List<List<Integer>> findSumOfFourNums(int[] nums, int target) {
        this.target = target;
        this.result = new ArrayList<>();
        int[] container = new int[4];
        dfs(nums, container, 0, new boolean[nums.length]);
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(int[] nums, int[] container, int len, boolean[] used) {
        if (len == 4) {
            int sum = Arrays.stream(container).sum();
            if (sum == target) {
                result.add(Arrays.stream(container).boxed().sorted().collect(Collectors.toList()));
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
