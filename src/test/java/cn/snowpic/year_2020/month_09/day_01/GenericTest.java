/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_09.day_01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class GenericTest {
    private static class A {
        private int a;
    }

    private static class B<T> extends A {
        private int b;

        private void m1(T t) {
            final String name = t.getClass().getSimpleName();
            System.out.println(name);
        }
    }

    @Test
    public void test1() {
        final B<String> b = new B<>();
        b.m1("");
    }

    @Test
    public void test2() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        final C c1 = new C();
        c1.aa = 66;
        c1.ee=88;
        final String s = mapper.writeValueAsString(c1);
        System.out.println("s = " + s);
        final C c = mapper.readValue(s, C.class);
        System.out.println("c = " + c);
    }

    private static class C {
        private int aa;

        private int ee;

        public void setAa(int aa) {
            this.aa = aa;
        }

        public int getAa() {
            return aa;
        }

        public void setEe(int ee) {
            this.ee = ee;
        }

        public int getEe() {
            return ee;
        }
    }
}