/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void test1() {
        List<List<Integer>> triangle1 = generatePascalTriangle(5);
        List<List<Integer>> triangle2 = generatePascalTriangle(2);

        System.out.println(triangle1);
        System.out.println(triangle2);
    }

    private List<List<Integer>> generatePascalTriangle(int numRow) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastLine = null;
        for (int i = 0; i < numRow; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            if (lastLine != null) {
                for (int j = 1; j < i; j++) {
                    line.add(lastLine.get(j - 1) + lastLine.get(j));
                }
                line.add(1);
            }
            lastLine = line;
            result.add(line);
        }

        return result;
    }
}