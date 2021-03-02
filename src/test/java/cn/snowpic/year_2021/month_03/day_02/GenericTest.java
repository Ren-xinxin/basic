package cn.snowpic.year_2021.month_03.day_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(searchRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    private int searchRotatedArray(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        AtomicInteger counter = new AtomicInteger();
        AtomicInteger counter2 = new AtomicInteger();
        List<String> collect = list.stream().filter(str -> {
            System.out.println("filter");
            return str != null;
        }).map(str -> {
            System.out.println("map");
            return str;
        }).sorted((str1, str2) -> {
            System.out.println("sorted");
            return str1.compareTo(str2);
        }).peek(str -> {
            counter.getAndIncrement();
            System.out.println("peek");
        }).skip(20).limit(10).peek(str -> {
            counter2.getAndIncrement();
            System.out.println("peek2");
        }).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(counter.get());
        System.out.println(counter2.get());
    }
}
