/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_27;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GenericTest {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            Map<Character, Integer> container = new HashMap<>();
            for (int i = 0; i < input.length(); i++) {
                char curr = input.charAt(i);
                container.merge(curr, 1, Integer::sum);
            }

            StringBuilder sb = new StringBuilder();
            container.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(c -> {
                for (int i = 0; i < c.getValue(); i++) {
                    sb.append(c.getKey());
                }
            });
            System.out.println(sb.toString());
        }
    }
}