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
        boolean bipartite = bipartite(graph);
        System.out.println("bipartite = " + bipartite);

        int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};

        boolean bipartite1 = bipartite(graph1);
        System.out.println("bipartite1 = " + bipartite1);
    }

    /**
     * bipartite
     *
     * @author lf
     * @time 2020-03-06 22:12:21
     * @param graph graph
     * @return boolean
     */
    private boolean bipartite(int[][] graph) {
        final State[] states = new State[graph.length];
        Arrays.fill(states, State.UNDEFINED);
        for (int i = 0; i < graph.length; i++) {
            // get related points' state.
            State temp = State.UNDEFINED;
            for (int j : graph[i]) {
                State relatedSate = states[j];
                if (relatedSate == State.UNDEFINED) continue;
                if (temp == State.UNDEFINED) temp = relatedSate;
                // if there are different state in related point, return false.
                if (temp != relatedSate) return false;
            }
            State currentSate = states[i];
            // if the origin's state is similar as the temp, return false.
            if (currentSate != State.UNDEFINED && currentSate == temp) return false;
            State requiredSate = (temp == State.UNDEFINED || temp == State.BLUE) ? State.RED : State.BLUE;
            if (currentSate == State.UNDEFINED) states[i] = requiredSate;
            // fill all the related points' state with the opposite.
            for (int index : graph[i]) {
                states[index] = State.negate(requiredSate);
            }
        }
        return true;
    }

    private enum State {
        RED, UNDEFINED, BLUE;

        public static State negate(State origin) {
            switch (origin) {
                case RED:
                    return BLUE;
                case BLUE:
                    return RED;
                default:
                    return null;
            }
        }
    }
}