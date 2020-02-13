package cn.snowpic.year_2019.month_06.month_06.day_14;

import org.junit.Test;

import java.util.*;

/**
 *@className GenericTest
 *@description generic test
 *@author lf
 *@date 2019/6/14 8:42
 *@version 1.0.0
 **/

public class GenericTest {

    /**
     * test1
     * @author lf
     * @date 2019/6/14 10:09
     */
    @Test
    public void test1() {
        long lo = System.currentTimeMillis();
        List<String> strings = new ArrayList<>();
        List<String> strings2 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(1);
            for (int j = 0; j < 10; j++) {
                builder.append(random.nextInt(10));
            }
            strings.add(builder.toString());
        }

        for (int i = 0; i < 10000; i++) {
            strings2.add(strings.get(random.nextInt(10)));
        }
        Set<String> phones = new HashSet<>(strings2);
        System.out.println("time:" + (System.currentTimeMillis() - lo));
        System.out.println(phones.size());

        strings2.forEach(System.out::println);
        System.out.println("time:" + (System.currentTimeMillis() - lo));
    }
}
