/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_04;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-03-04 18:53:49
 */
public class GenericTest {

    /**
     * is bipartite
     *
     * @author lf
     * @time 2020-03-05 22:41:42
     * @param graph graph
     * @return boolean
     */
    private boolean isBipartite(int[][] graph) {
        HashMap<Integer, List<Integer>> relationships = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            relationships.put(i, Arrays.stream(graph[i])
                    .boxed()
                    .collect(Collectors.toList()));
        }
        Map<Integer, Integer> colorMap = new HashMap<>();
        AtomicBoolean result = new AtomicBoolean(true);
        for (int i = 0; i < graph.length; i++) {
            if (colorMap.get(i) == null) {
                colorTrack(i, 1, relationships, colorMap, result);
                if (!result.get()) return false;
            }
        }
        return true;
    }

    /**
     * color track
     *
     * @author lf
     * @time 2020-03-05 22:41:59
     * @param index index
     * @param requiredColor required color
     * @param relationships relationships
     * @param colorMap color map
     * @param result result
     */
    private void colorTrack(int index, int requiredColor, HashMap<Integer, List<Integer>> relationships, Map<Integer, Integer> colorMap, AtomicBoolean result) {
        Integer color = colorMap.get(index);
        if (color == null) {
            colorMap.put(index, requiredColor);
        } else if (color == requiredColor) {
            return;
        } else {
            result.set(false);
            return;
        }
        List<Integer> relationship = relationships.get(index);
        for (Integer current : relationship) {
            if (requiredColor == 1) {
                colorTrack(current, -1, relationships, colorMap, result);
            } else {
                colorTrack(current, 1, relationships, colorMap, result);
            }
            if (!result.get()) return;
        }
    }

    @Test
    public void test1() {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean bipartite = isBipartite(graph);
        System.out.println("bipartite = " + bipartite);
    }
}