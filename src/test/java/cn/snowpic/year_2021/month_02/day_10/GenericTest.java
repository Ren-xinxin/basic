package cn.snowpic.year_2021.month_02.day_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericTest {
    @Test
    public void test1() {
        int result = getMinDegreeLen(new int[]{1, 2, 2, 3, 1});
        System.out.println(result);
        System.out.println(getMinDegreeLen(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    private int getMinDegreeLen(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.merge(num, 1, Integer::sum);
        }
        int maxTimes = map.values().stream().mapToInt(i -> i).max().orElse(0);
        List<String> keys = map.entrySet().stream().filter(entry -> entry.getValue().equals(maxTimes))
                .map(Map.Entry::getKey).map(String::valueOf).collect(Collectors.toList());
        String str = Arrays.stream(array).boxed().map(String::valueOf).collect(Collectors.joining(""));
        int result = Integer.MAX_VALUE;
        for (String key : keys) {
            int left = str.indexOf(key);
            int right = str.lastIndexOf(key);
            if (left < right) {
                result = Math.min(result, right - left + 1);
            }
        }
        return result;
    }
}
