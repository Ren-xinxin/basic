package cn.snowpic.year_2021.month_02.day_28;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenericTest1 {
    @Test
    public void test1() {
        System.out.println(checkGame(new int[]{5, 5, 5, 1}));
        System.out.println(checkGame(new int[]{3, 3, 7, 7}));
        System.out.println(checkGame(new int[]{1, 1, 1, 1}));
        System.out.println(checkGame(new int[]{1, 1, 1, 2}));
        System.out.println(checkGame(new int[]{3, 3, 7, 1}));
    }

    private boolean checkGame(int[] array) {
        this.input = new double[array.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = array[i];
        }
        this.container = new double[array.length];
        this.used = new boolean[array.length];
        this.table = new HashMap<>();
        try {
            dfs(0);
            return false;
        } catch (RuntimeException re) {
            return true;
        }
    }

    private double[] input;

    private double[] container;

    private boolean[] used;

    private Map<String, Set<Double>> table;

    private boolean flag;

    private void dfs(int curr) {
        if (curr == 2) {
            double v1 = container[0];
            double v2 = container[1];
            calc(v1, v2);
        }
        String key = getKey(container[0], container[1]);
        if (curr == 3) {
            for (Double value : table.get(key)) {
                calc(value, container[curr - 1]);
            }
        }
        if (curr == 4) {
            flag = true;
            for (Double value : table.get(key)) {
                String key1 = getKey(value, container[curr - 2]);
                for (Double localValue : table.get(key1)) {
                    calc(localValue, container[curr - 1]);
                }
            }
            flag = false;
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            container[curr] = input[i];
            dfs(curr + 1);
            used[i] = false;
        }
    }

    private void calc(double v1, double v2) {
        String key = getKey(v1, v2);
        Set<Double> val = table.get(key);
        if (val == null) {
            val = new HashSet<>();
            val.add(v1 + v2);
            val.add(v1 - v2);
            val.add(v2 - v1);
            val.add(v1 * v2);
            if (v2 != 0) {
                val.add(v1 / v2);
            }
            if (v1 != 0) {
                val.add(v2 / v1);
            }
            if (flag && val.stream().anyMatch(value -> Math.abs(value - 24) < 1e-6)) {
                System.out.println("find it...");
                throw new RuntimeException();
            }
            table.put(key, val);
        }
    }

    private String getKey(double v1, double v2) {
        String key;
        if (v2 > v1) {
            key = v1 + "," + v2;
        } else {
            key = v2 + "," + v1;
        }
        return key;
    }
}
