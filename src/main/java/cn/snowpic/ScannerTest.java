package cn.snowpic;

import java.util.Scanner;

/**
 * @className ScannerTest
 * @description
 * @author lf
 * @time 2019/7/26 22:30
 **/

public class ScannerTest {

    public static void main(String[] args) {
        System.out.println("请输入一个3位数字");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String next = scanner.next();
            String[] split = next.split("");
            int target = Integer.parseInt(next);
            int sum = 0;
            for (int index = split.length - 1; index >= 0; index--) {
                sum += Math.pow(Integer.parseInt(split[index]), 3);
            }
            if (sum == target) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
