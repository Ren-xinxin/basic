package cn.snowpic.year_2019.month_09.day_30;

import org.junit.Test;

import java.util.Scanner;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/9/30 21:04
 */

@SuppressWarnings("ALL")
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/9/30 21:05
     */
    @Test
    public void test1() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String x = scanner
                    .next()
                    .replaceAll("\\?|？", "!")
                    .replaceAll("吗", "")
                    .replaceAll("你", "我");
            System.out.println("input is : " + x);
        }
    }
}
