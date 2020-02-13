package cn.snowpic.year_2019.month_05.day_31;

/**
 * @className: C
 * @description:
 * @author: lf
 * @date: 2019/5/31 11:52
 * @version: 1.0.0
 **/

public class C {
    static {
        System.out.println();//1
    }

    public static int count = 0;//2

    {
        System.out.println(count++);//3
    }

    public int i = 0;//4

    public C() {
        System.out.println(i);
        System.out.println(count++);//5
    }
}
