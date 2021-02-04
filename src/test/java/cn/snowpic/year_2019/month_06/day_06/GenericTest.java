package cn.snowpic.year_2019.month_06.day_06;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @className: GenericTest
 * @description: generic test
 * @author: lf
 * @date: 2019/6/6 8:39
 * @version: 1.0.0
 **/

public class GenericTest {

    @Test
    public void test1() {
        Integer ii = 11;
        int i = 11;
        System.out.println(ii == i);
        System.out.println(ii.equals(i));
        System.out.println(String.valueOf(ii));
    }

    @Test
    public void test2() {
        List list = new LinkedList();
        list.add(null);
        list.add(null);
        list.add("aaa");
        list.add(123);

        list.forEach(System.out::println);

        System.out.println("=====================================");

        Set set =  new LinkedHashSet();
        set.add(null);
        set.add(null);
        set.add("aaa");
        set.add(123);

        set.forEach(System.out::println);
    }
}
