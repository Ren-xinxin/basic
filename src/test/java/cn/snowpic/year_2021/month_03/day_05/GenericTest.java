package cn.snowpic.year_2021.month_03.day_05;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        int[][] img = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage(img);
        System.out.println(Arrays.deepToString(img));
        int[][] img2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotateImage(img2);
        System.out.println(Arrays.deepToString(img2));
    }

    private void rotateImage(int[][] img) {
        int totalLen = img.length - 1;
        int columnLimit = totalLen;
        int row = 0;
        while (row <= img.length / 2) {
            int column = row;
            while (column < columnLimit) {
                setValue(img, row, column, 0, totalLen, img[row][column]);
                column++;
            }
            row++;
            columnLimit--;
        }
    }

    private void setValue(int[][] img, int x, int y, int times, int len, int nextVal) {
        if (times == 4) {
            return;
        }
        int x1 = y;
        int y1 = len - x;
        int oldVal = nextVal;
        nextVal = img[x1][y1];
        img[x1][y1] = oldVal;
        setValue(img, x1, y1, times + 1, len, nextVal);
    }
}
