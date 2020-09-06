/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_09.day_06;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GenericTest {
    private static class Aa {
        private String age;

        private Aa itself;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Aa)) return false;
            Aa aa = (Aa) o;
            return age.equals(aa.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }

    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException {
        final HashSet<Aa> set = new HashSet<>();
        final Aa e = new Aa();
        e.age = "22";
        final Aa e1 = new Aa();
        e1.age = "22";
        set.add(e);

        final ArrayList<Aa> list = new ArrayList<>();
        list.add(e);
        list.add(e1);

        final List<Aa> collect = list.stream().distinct().collect(Collectors.toList());
        final Aa o = new Aa();
        o.age="66";
        list.remove(o);
        final Class<? extends Aa> aa = e.getClass();
        final Field field = aa.getDeclaredField("age");
        final Field itself = aa.getDeclaredField("itself");
        final Type type = field.getGenericType();
        System.out.println(type.getTypeName());
        System.out.println(itself.getType().getName());
        itself.setAccessible(true);
        final Object o1 = itself.get(o);
        System.out.println();

        list.forEach(a->{
            final String len = a.itself.age;
            System.out.println(len);
        });
    }
}