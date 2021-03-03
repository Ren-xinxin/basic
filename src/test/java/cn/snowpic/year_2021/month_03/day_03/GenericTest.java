package cn.snowpic.year_2021.month_03.day_03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(getPermutationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(getPermutationSum(new int[]{2, 3, 6, 7}, 2));
        System.out.println(getPermutationSum(new int[]{2, 3, 5}, 8));
    }

    private List<Integer> input;

    private int target;

    private List<List<Integer>> result;

    private List<List<Integer>> getPermutationSum(int[] nums, int target) {
        input = Arrays.stream(nums).boxed().distinct().sorted().collect(Collectors.toList());
        this.target = target;
        this.result = new ArrayList<>();
        dfs(new ArrayList<>(), 0);
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(List<Integer> curr, int index) {
        int sum = curr.stream().mapToInt(Integer::intValue).sum();
        if (sum >= target || index >= input.size()) {
            if (sum == target) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        int value = input.get(index);
        curr.add(value);
        dfs(curr, index);
        curr.remove(curr.size() - 1);
        dfs(curr, index + 1);
    }
}
