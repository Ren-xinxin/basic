package cn.snowpic.year_2019.day_06_19;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Comparator;

/**
 * generic test
 * @className GenericTest
 * @author lf
 * @time 2019/6/19 14:16
 */

public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/6/19 14:10
     */
    @Test
    public void test1() {
        double x = 2.0;
        int y = 4;
        x /= ++y;
        System.out.println(x);
        x %= 4;
        System.out.println(x);
    }


    @Test
    public void test2() {
        Integer[] list = {1, 6, 4, 232, 8, 232, 9};
        new BubbleSorter<Integer>().sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3() {
        Singleton.INSTANCE.m1();
    }

    /**
     * break test
     * @author lf
     * @time 2019/6/19 16:05
     */
    @Test
    public void test4() {
        outer:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == 2 && j == 4) break outer;
                System.out.println("i======j" + i + "=========" + j);
            }
        }
    }

    @Test
    public void test5() {
        int i = 100 % 3;
        double j = 100 % 3.0;

        double k = 100 * 1.0;
        System.out.println(i + j + k);
    }

    /**
     * NIO test6
     * @author lf
     * @time 2019/6/19 20:38
     */

    @Test
    public void test6() throws IOException {
        long old = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:/迅雷下载/美少女万华镜汉化版四部合集.rar");
        FileOutputStream fos = new FileOutputStream("f:/万华镜/美少女万华镜汉化版四部合集.rar");


        FileChannel fci = fis.getChannel();
        FileChannel fco = fos.getChannel();

        fci.transferTo(0, fci.size(), fco);
        System.out.println("time passed for " +
                (System.currentTimeMillis() - old) + " milliseconds");

    }
}

enum Singleton {
    INSTANCE, INSTANCE2;
    private int a;

    private static final int ssss = 1;

    Singleton() {
        System.out.println("no args constructor......");
    }

    void m1() {

    }

    void m2() {

    }

    void m3() {

    }
}

interface Sorter<T> {
    <T extends Comparable<T>> void sort(T[] list);

    <T> void sort(T[] list, Comparator<T> comparator);
}

class BubbleSorter<T> implements Sorter<T> {

    /**
     * sort
     * @author lf
     * @time 2019/6/19 15:33
     * @param list list
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    /**
     * sort
     * @author lf
     * @time 2019/6/19 15:33
     * @param list list
     * @param comparator comparator
     */
    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}