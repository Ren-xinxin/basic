/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_09.day_06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GenericTest {
    private static class Aa {
        private String age;

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
    public void test1() {
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
    }
}