package cn.snowpic.year_2021.month_03.day_04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(getPermutationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(getPermutationSum(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(counter.get());
    }

    private int[] input;

    private int target;

    private List<List<Integer>> result;

    private boolean[] used;

    private final AtomicInteger counter = new AtomicInteger();

    private List<List<Integer>> getPermutationSum(int[] nums, int target) {
        input = nums;
        this.target = target;
        this.result = new ArrayList<>();
        this.used = new boolean[nums.length];
        dfs(new ArrayList<>());
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(List<Integer> curr) {
        counter.getAndIncrement();
        int sum = curr.stream().mapToInt(Integer::intValue).sum();
        if (sum >= target) {
            if (sum == target) {
                result.add(curr.stream().sorted().collect(Collectors.toList()));
            }
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            curr.add(input[i]);
            dfs(curr);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
