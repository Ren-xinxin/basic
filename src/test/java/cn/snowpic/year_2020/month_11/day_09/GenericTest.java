/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(generatePascalTriangle2(3));
        System.out.println(generatePascalTriangle2(1));
    }

    private List<Integer> generatePascalTriangle2(int lineIndex) {
        List<List<Integer>> container = new ArrayList<>();
        for (int i = 0; i <= lineIndex; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            if (i > 0) {
                List<Integer> lastLine = container.get(i - 1);
                for (int j = 1; j < i; j++) {
                    int curr = lastLine.get(j - 1) + lastLine.get(j);
                    line.add(curr);
                }
                line.add(1);
            }
            container.add(line);
        }
        return container.get(container.size() - 1);
    }
}