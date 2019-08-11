package cn.snowpic;

import java.util.HashMap;

/**
 * @className Reflect
 * @description
 * @author lf
 * @time 2019/8/11 10:16
 **/

public class Reflect {

    private static final String TOM = "tom";

    private static int i = 0;

    public int math(int i, int j, int k) {
        int tem = i + j;
        k = k * tem;
        tem = k + 1;
        m1();
        return tem;
    }

    public static void main(String[] args) {
        System.out.println("some thing good..");
        Reflect reflect = new Reflect();
        int math = reflect.math(1, 2, 3);
        System.currentTimeMillis();
        System.out.println(math);
    }

    public void m1() {
        int i = 1;
        int j = 2;
        j = i + j;
    }
}
