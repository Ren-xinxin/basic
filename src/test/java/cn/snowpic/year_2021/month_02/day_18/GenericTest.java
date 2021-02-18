package cn.snowpic.year_2021.month_02.day_18;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(countMagicSquare(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
    }

    private int countMagicSquare(int[][] square) {
        int xLen = square.length;
        int yLen = square[0].length;
        int result = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (square[i][j] != 5) {
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                int tempX, tempY, tempSum;
                tempX = i - 1;
                tempY = j - 1;
                if (tempX < 0 || tempY < 0 || !set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum = square[tempX][tempY];
                tempX = i + 1;
                tempY = j + 1;
                if (tempX >= xLen || tempY >= yLen || !set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum += square[tempX][tempY];
                if (tempSum != 10) {
                    continue;
                }
                tempX = i - 1;
                tempY = j;
                if (!set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum = square[tempX][tempY];
                tempX = i + 1;
                if (!set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum += square[tempX][tempY];
                if (tempSum != 10) {
                    continue;
                }
                tempX = i - 1;
                tempY = j + 1;
                if (!set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum = square[tempX][tempY];
                tempX = i + 1;
                tempY = j - 1;
                if (!set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum += square[tempX][tempY];
                if (tempSum != 10) {
                    continue;
                }
                tempX = i;
                tempY = j + 1;
                if (!set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum = square[tempX][tempY];
                tempY = j - 1;
                if (!set.add(square[tempX][tempY])) {
                    continue;
                }
                tempSum += square[tempX][tempY];
                if (tempSum != 10) {
                    continue;
                }
                result++;
            }
        }
        return result;
    }
}
