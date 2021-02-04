/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_10.day_24;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/10/24 22:09
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/10/24 22:10
     */
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(6);
            add(3);
            add(8);
        }};

        List<Integer> list2 = new ArrayList<Integer>() {{
            add(6);
            add(3);
            add(666);
        }};

        // 交集
        list.stream().filter(list2::contains).forEach(System.out::println);

        Optional<Integer> reduce = list2.stream().reduce((x1, x2) -> x1 + x2 + 1);

        reduce.ifPresent(System.out::println);

        Map<String, Object> map = new HashMap<>();
        Object s = map.putIfAbsent(null, null);
        System.out.println("map = " + map);
        System.out.println("s = " + s);
        Object s1 = map.putIfAbsent(null, "kkk");
        System.out.println("map = " + map);
        System.out.println("s = " + s1);

        map.merge("9", "1", (vo, vn) -> String.valueOf(vo).concat(String.valueOf(vn)));
        map.merge("9", "rxx", (vo, vn) -> String.valueOf(vo).concat(String.valueOf(vn)));

        System.out.println("map.get(\"9\") = " + map.get("9"));
    }

    @Test
    public void test2() {
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("RXX_ID", i + "");
            map.put("RXX_NAME", "任新新" + i);
            map.put("RXX_AGE", 18 + i + "");
            list.add(map);
        }
        String field = "rxxName";

        long t1 = System.currentTimeMillis();
        AtomicLong t2 = new AtomicLong(0);
        AtomicLong t3 = new AtomicLong(0);
        List<String> names = list.stream()
                .map(l -> {
                    t2.set(System.currentTimeMillis());
                    String key = l.keySet().stream()
                            .filter(k -> k.replaceAll("_", "").equalsIgnoreCase(field))
                            .findAny()
                            .orElse(null);
                    t3.set(System.currentTimeMillis());
                    return l.get(key);
                }).collect(Collectors.toList());
        long t4 = System.currentTimeMillis();
        String field1 ="sss";
        System.out.println("(System.currentTimeMillis()-t4) = " + (System.currentTimeMillis() - t4));
        System.out.println("t4-t1 = " + (t4 - t1));
        System.out.println("(t3.get()-t2.get()) = " + (t3.get() - t2.get()));


        names.forEach(System.out::println);
    }
}
