package cn.snowpic.year_2021.month_02.day_27;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<List<Integer>> permutations;

    @Test
    public void test2() {
        System.out.println(getPermutations(4).size());
        System.out.println(getPermutations(3));
        System.out.println(getPermutations(8).size());
        long start = System.currentTimeMillis();
        System.out.println(getPermutations(9).size());
        System.out.println("cost:" + (System.currentTimeMillis() - start));
        System.out.println(getPermutations(1));
        System.out.println("=======================");
        System.out.println(getPermutations2(4).size());
        System.out.println(getPermutations2(3));
        System.out.println(getPermutations2(8).size());
        start = System.currentTimeMillis();
        System.out.println(getPermutations2(9).size());
        System.out.println("cost:" + (System.currentTimeMillis() - start));
        System.out.println(getPermutations2(1));
    }

    private List<List<Integer>> getPermutations(int num) {
        permutations = new ArrayList<>();
        int[] nums = new int[num];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        outer:
        while (true) {
            addPermutation(nums);
            if (nums.length < 2) {
                break;
            }
            int index1 = nums.length - 1;
            int index2 = index1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    index1 = i;
                    break;
                }
                if (i == 0) {
                    break outer;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[index1]) {
                    index2 = i;
                    break;
                }
            }
            swap(nums, index1, index2);
            reverse(nums, index1 + 1);
        }
        return permutations;
    }

    private void reverse(int[] nums, int index) {
        int left = index, right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void addPermutation(int[] nums) {
        permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    private List<List<Integer>> getPermutations2(int num) {
        permutations = new ArrayList<>();
        int[] nums = new int[num];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        perDfs(nums, 0, new int[num], new boolean[num]);
        return permutations;
    }

    private void perDfs(int[] nums, int curr, int[] container, boolean[] used) {
        if (curr == nums.length) {
            addPermutation(container);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            container[curr] = nums[i];
            perDfs(nums, curr + 1, container, used);
            used[i] = false;
        }
    }
}
