package cn.snowpic.year_2021.month_02.day_21;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(Arrays.toString(findExchangeIndexes(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(findExchangeIndexes(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(findExchangeIndexes(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(findExchangeIndexes(new int[]{1, 2, 5}, new int[]{2, 4})));
    }

    private int[] findExchangeIndexes(int[] candies1, int[] candies2) {
        int sum1 = Arrays.stream(candies1).sum();
        int sum2 = Arrays.stream(candies2).sum();
        Set<Integer> set = Arrays.stream(candies2).boxed().collect(Collectors.toSet());
        // sum1 - sum2 = x
        // sum1 - candy + other  = sum2 + candy - other
        // sum1 - sum2 = (candy - other) * 2
        int diff = (sum1 - sum2) / 2;
        for (int candy : candies1) {
            int other = candy - diff;
            if (set.contains(other)) {
                return new int[]{candy, other};
            }
        }
        return new int[]{-1, -1};
    }
}
