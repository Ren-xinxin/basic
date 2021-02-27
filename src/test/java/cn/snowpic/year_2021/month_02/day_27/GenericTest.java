package cn.snowpic.year_2021.month_02.day_27;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    private int result;

    private int target;

    @Test
    public void test1() {
        System.out.println(findClosestSumOfNums(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(findClosestSumOfNums(new int[]{-1, 2, 1, -4}, 2));
        System.out.println(findClosestSumOfNums(new int[]{-1, 2, 1, -4}, 0));
    }

    private int findClosestSumOfNums(int[] nums, int target) {
        this.target = target;
        this.result = Integer.MAX_VALUE;
        int[] container = new int[3];
        dfs(nums, container, 0, new boolean[nums.length]);
        return result;
    }

    private void dfs(int[] nums, int[] container, int len, boolean[] used) {
        if (len == 3) {
            int sum = Arrays.stream(container).sum();
            if (Math.abs(sum - target) < Math.abs(result - target)) {
                result = sum;
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
