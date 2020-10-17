/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_17;

public class InnerClassSingleton {
    private static class Instance {
        public Instance() {
            System.out.println("Instance constructor");
        }

        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        System.out.println("InnerClassSingleton constructor");
    }

    private int age;

    public static InnerClassSingleton getInstance(){
        return Instance.INSTANCE;
    }
}