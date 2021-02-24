package cn.snowpic.year_2021.month_02.day_24;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(checkCardsGroup(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(checkCardsGroup(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(checkCardsGroup(new int[]{1, 1}));
    }

    private boolean checkCardsGroup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : cards) {
            map.merge(card, 1, Integer::sum);
        }
        List<Integer> values = map.values().stream().distinct().collect(Collectors.toList());
        return values.size() == 1 && values.get(0) > 1;
    }

    @Test
    public void test2() {
        System.out.println(splitNum(6));
        System.out.println(splitNum(7));
        System.out.println(splitNum(8));
        System.out.println(splitNum(11));
        System.out.println(splitNum(100));
    }

    private String splitNum(int num) {
        int numCopy = num;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                num /= i;
                factors.add(i);
            }
        }
        return factors.stream().map(String::valueOf).collect(Collectors.joining("*")) + "=" + numCopy;
    }
}
