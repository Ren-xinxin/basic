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
     * @param start start
     * @return int
     */
    private int resolveScore(String input, AtomicInteger start) {
        int pow = -1;
        int sum = 0;
        boolean flag = false;
        for (int i = start.get() + 1; i < input.length(); i++) {
            start.set(i);
            char curr = input.charAt(i);
            if (curr == ')') {
                pow++;
                flag = true;
            } else if (curr == '(' && flag) {
                sum = (int) Math.pow(2, pow);
                pow = -1;
                sum += resolveScore(input, start);
                i = start.get();
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
