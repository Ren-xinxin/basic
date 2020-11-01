/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        // 对于用户不同
        // n
        // resA
        // 3
        // 15 8 17
        // 12 20 9
        // 11 7 5
        // 24
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int users = Integer.parseInt(sc.nextLine());

            int next = 0;

            int sum = 0;
            List<Map.Entry<Integer, Integer>> nextData = null;
            for (int i = 0; i < users - 1; i++) {
                List<Map.Entry<Integer, Integer>> data;
                if (nextData == null) {
                    data = getData(sc);
                } else {
                    data = nextData;
                }
                nextData = getData(sc);

                int min = Integer.MAX_VALUE;
                Map.Entry<Integer, Integer> curr1 = data.get(next);
                // index
                int tempCurr = curr1.getKey();
                for (int k = 0; k < 2; k++) {
                    Map.Entry<Integer, Integer> nextD = nextData.get(k);
                    Integer tempNext = nextD.getKey();
                    if (tempNext != tempCurr) {
                        int temp = curr1.getValue() + nextD.getValue();
                        if (temp < min) {
                            min = temp;
                            next = k;
                        }
                    }
                }


                if (i < users - 2) {
                    sum += (min - nextData.get(next).getValue());
                } else {
                    sum += min;
                }
            }
            System.out.println(sum);
        }
    }

    private static List<Map.Entry<Integer, Integer>> getData(Scanner sc) {
        String line = sc.nextLine();
        String[] split = line.split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, Integer.parseInt(split[0]));
        map.put(1, Integer.parseInt(split[1]));
        map.put(2, Integer.parseInt(split[2]));

        return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
    }
}