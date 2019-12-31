/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_31;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/31 18:49
 */
public class GenericTest {

    /**
     * test1 of max area with the ocean...
     * @author lf
     * @time 2020/1/1 0:17
     */
    @Test
    public void test1() {
        int[][] island = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        int area = maxIslandArea(island);
        System.out.println("area = " + area);
    }

    /**
     * max island area
     * @author lf
     * @time 2019/12/31 18:52
     * @param island island
     * @return int
     */
    private int maxIslandArea(int[][] island) {
        int max = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                Set<List<Integer>> container = new HashSet<>();
                deepFirstSearch(container, island, i, j);
                max = Math.max(max, container.size());
            }
        }
        return max;
    }

    private int counter = 0;

    /**
     * deep first search
     * @author lf
     * @time 2020/1/1 0:05
     * @param container container
     * @param island island
     * @param x x
     * @param y y
     */
    private void deepFirstSearch(Set<List<Integer>> container, int[][] island, int x, int y) {
        if (x < 0
                || y < 0
                || x > island.length - 1
                || y > island[0].length - 1
                || island[x][y] == 0) {
            return;
        }
        boolean added = container.add(new ArrayList<Integer>() {{
            add(x);
            add(y);
        }});
        if (!added) {
            // tip: very important
            return;
        }
        // four direction
        deepFirstSearch(container, island, x - 1, y); // left
        deepFirstSearch(container, island, x + 1, y); // right
        deepFirstSearch(container, island, x, y - 1); // up
        deepFirstSearch(container, island, x, y + 1); // down
    }

    /**
     * test2 of arrayList
     * @author lf
     * @time 2020/1/1 0:14
     */
    @Test
    public void test2() {
        Set<List<Integer>> container = new HashSet<>();
        container.add(new ArrayList<Integer>() {{
            add(2);
            add(3);
        }});
        container.add(new ArrayList<Integer>() {{
            add(2);
            add(3);
        }});
        System.out.println("container.size() = " + container.size());
    }
}
