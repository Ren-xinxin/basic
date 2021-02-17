package cn.snowpic.year_2021.month_02.day_17;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findLargestTwice(new int[]{3, 6, 1, 0}));
        System.out.println(findLargestTwice(new int[]{1, 2, 3, 4}));
    }

    private int findLargestTwice(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        int finalMax = max;
        return Arrays.stream(array)
                .anyMatch(num -> num != 0 && num != finalMax && finalMax / num < 2) ? -1 : index;
    }

    @Test
    public void test2() {
        System.out.println(checkToeplitz(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println(checkToeplitz(new int[][]{{1, 2}, {2, 2}}));
    }

    private boolean checkToeplitz(int[][] matrix) {
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int y = yLen - 1;
        int x = 0;
        while (x < xLen) {
            int curr = matrix[x][y];
            int tempX = x;
            int tempY = y;
            while (++tempX < xLen && ++tempY < yLen) {
                if (matrix[tempX][tempY] != curr) {
                    return false;
                }
            }
            if (y > 0) {
                y--;
            } else {
                x++;
            }
        }
        return true;
    }

    @Test
    public void test3() {
        System.out.println(countSubdomainVisit(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(countSubdomainVisit(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com",
                "5 wiki.org"}));
    }

    private List<String> countSubdomainVisit(String[] origin) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : origin) {
            String[] split = str.split(" ");
            int index = -1;
            String domain = split[1];
            int count = Integer.parseInt(split[0]);
            map.merge(domain, count, Integer::sum);
            while ((index = domain.indexOf(".", index + 1)) != -1) {
                String key = domain.substring(index + 1);
                map.merge(key, count, Integer::sum);
            }
        }
        return map.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }
}
