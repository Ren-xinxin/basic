/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_30;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericTest {

    private static final char ORIGIN = 'a';

    private AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.submit(() -> {
            while (counter.get() < 26) {
                synchronized (this) {
                    try {
                        wait();
                        print();
                        notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        pool.submit(() -> {
            while (counter.get() < 26) {
                synchronized (this) {
                    try {
                        notify();
                        wait();
                        print();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * print
     *
     * @author Little Flower
     * @date 2020-03-30 20:58:06
     */
    private void print() {
        char str = (char) (ORIGIN + counter.getAndIncrement());
        System.out.println(Thread.currentThread().getName() + ":" + str);
    }

    @Test
    public void test2() {
        System.out.println(computeScore("()"));
        System.out.println(computeScore("(())"));
        System.out.println(computeScore("()()"));
        System.out.println(computeScore("(()(()))"));
    }

    /**
     * resolve score
     *
     * @author Little Flower
     * @date 2020-03-30 22:48:02
     * @param input input
     * @param cursor cursor
     * @return int
     */
    private int resolveScore(String input, AtomicInteger cursor) {
        int counter = 0;
        int sum = 1;
        // whether first time enter flag.
        boolean flag = true;
        for (; cursor.get() < input.length(); cursor.getAndIncrement()) {
            char curr = input.charAt(cursor.get());
            if (curr == '(' && flag) {
                counter++;
            } else if (curr == ')') {
                if (--counter < 0) { // the counter is out of bound, it's incorrect.
                    // roll back the cursor.
                    cursor.getAndDecrement();
                    return sum;
                }
                if (flag) {
                    flag = false;
                    continue;
                }
                // power up the value base on 2, left move.
                sum <<= 1;
            } else {
                // add the next depth value.
                sum += resolveScore(input, cursor);
            }
        }
        return sum;
    }

    /**
     * compute score
     *
     * @author Little Flower
     * @date 2020-03-30 22:47:55
     * @param input input
     * @return int
     */
    private int computeScore(String input) {
        checkFormat(input);
        return resolveScore(input, new AtomicInteger(0));
    }

    /**
     * check format
     *
     * @author Little Flower
     * @date 2020-03-30 22:28:01
     * @param input input
     */
    private void checkFormat(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("Input's format is illegal.");
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '(') {
                deque.push('(');
            } else if (!deque.isEmpty() && curr == ')') {
                deque.pop();
            } else {
                throw new IllegalArgumentException("Input's format is illegal.");
            }
        }
        if (!deque.isEmpty()) {
            throw new IllegalArgumentException("Input's format is illegal.");
        }
    }
}
