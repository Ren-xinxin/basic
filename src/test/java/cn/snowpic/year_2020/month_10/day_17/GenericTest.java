/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_17;

import org.junit.Test;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println("hello");
        InnerClassSingleton.getInstance();
    }

    @Test
    public void test2() {
        final EnumSingleton instance = EnumSingleton.INSTANCE;
        System.out.println(instance.name());
    }
}