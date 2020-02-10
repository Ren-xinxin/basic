/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_10;

import org.eclipse.jetty.util.BlockingArrayQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericTest {

    /**
     * reverse word
     *
     * @author lf
     * @time 2020-02-10 11:02:56
     * @param input input
     * @return String
     */
    private String reverseWord(String input) {
        String[] split = input.split("[ ]+");
        for (int i = 0; i < split.length; i++) {
            split[i] = reverse(split[i]);
        }
        return String.join(" ", split);
    }

    /**
     * reverse
     *
     * @author lf
     * @time 2020-02-10 11:02:50
     * @param input input
     * @return String
     */
    private String reverse(String input) {
        int left = 0;
        int right = input.length() - 1;
        char[] chars = input.toCharArray();
        while (left < right) {
            char tep = chars[left];
            chars[left] = chars[right];
            chars[right] = tep;
            left++;
            right--;
        }
        return new String(chars);
    }

    @Test
    public void test1() {
        String input = "Let's take LeetCode contest";
        String reverseWord = reverseWord(input);

        System.out.println("reverseWord = " + reverseWord);
    }

    static class Node {
        private Node left;
        private Node right;

        private Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        public Node(List<Integer> list) {
            AtomicInteger index = new AtomicInteger();
            value = list.get(index.get());
            setChild(list, index, 1, new BlockingArrayQueue<>());
        }

        public void setChild(List<Integer> container, AtomicInteger index, int pow, Queue<Node> children) {
            if (index.incrementAndGet() < container.size()) {
                left = new Node(container.get(index.get()));
                children.add(left);
            }
            if (index.incrementAndGet() < container.size()) {
                right = new Node(container.get(index.get()));
                children.add(right);
            }
            if (index.get() >= children.size() || children.size() == 2 << pow) {
                Node node;
                while ((node = children.poll()) != null) {
                    node.setChild(container, index, pow + 1, new BlockingArrayQueue<>());
                }
            }
        }

        @Override
        public String toString() {
            return value == null ? "" :
                    (value
                            // left node leaf
                            + (left == null ? "" : (left.value == null ? "()" : "(" + left + ")"))
                            // right node leaf
                            + (right == null ? "" : ("(" + right + ")"))
                    );
        }
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
        }};
        Node node = new Node(list);
        System.out.println("node = " + node);
    }

    static class Heap {

        private int[] data;

        private int len;

        /**
         * create a min heap by default
         */
        private boolean isCreateMinHeap = true;

        public Heap(int[] data) {
            this.data = data;
            this.len = data.length;
        }

        public Heap(int[] data, boolean isCreateMinHeap) {
            this(data);
            this.isCreateMinHeap = isCreateMinHeap;
        }

        /**
         * swap
         *
         * @author lf
         * @time 2020-02-10 14:54:13
         * @param a a
         * @param b b
         */
        private void swap(int a, int b) {
            int tep = data[a];
            data[a] = data[b];
            data[b] = tep;
        }

        /**
         * sift down
         *
         * @author lf
         * @time 2020-02-10 15:14:04
         * @param index index
         */
        private void siftDown(int index) {
            while (true) {
                int min = index;
                int leftChildIndex = (index + 1) * 2 - 1;
                int rightChildIndex = (index + 1) * 2;
                // find the min index between it and its' children
                if (leftChildIndex < len) {
                    if (rightChildIndex < len) {
                        min = compare(data[rightChildIndex], data[min]) ? rightChildIndex : min;
                    }
                    min = compare(data[leftChildIndex], data[min]) ? leftChildIndex : min;
                } else {
                    break;
                }
                // whether current index value is the min
                if (index != min) {
                    // swap the value between current and min index
                    swap(index, min);
                    // set current to min and continue execute the loop
                    index = min;
                } else {
                    // current index value is the min, break the loop
                    break;
                }
            }
        }

        /**
         * creat
         *
         * @author lf
         * @time 2020-02-10 15:20:37
         */
        private void creat() {
            // start sift down loop with the last no-leaf node
            for (int i = (len / 2) - 1; i >= 0; i--) {
                siftDown(i);
            }
        }

        @Override
        public String toString() {
            return "{" +
                    "\"data\":" + print(0) +
                    "}";
        }

        /**
         * print
         *
         * @author lf
         * @time 2020-02-10 16:02:48
         * @param index index
         * @return String
         */
        public String print(int index) {
            String result = String.valueOf(data[index]);
            int right = 2 * (index + 1);
            int left = right - 1;
            result += left < len ? ("(" + print(left) + ")") : "";
            result += right < len ? ("(" + print(right) + ")") : "";
            return result;
        }

        /**
         * compare
         *
         * @author lf
         * @time 2020-02-10 16:13:05
         * @param a a
         * @param b b
         * @return boolean
         */
        private boolean compare(int a, int b) {
            return isCreateMinHeap ? a - b < 0 : a - b > 0;
        }

        /**
         * poll
         *
         * @author lf
         * @time 2020-02-10 16:33:45
         * @return int
         */
        public int poll() {
            if (len <= 0) {
                return -1;
            }
            int result = data[0];
            // move the last element to the top
            data[0] = data[len - 1];
            len--;
            // sift down the binary tree again to keep it suitable
            siftDown(0);
            return result;
        }
    }

    @Test
    public void test4() {
        int[] array = {1, 4, 5, 6, 7, 8, 98, 3, 23};
        Heap heap = new Heap(array, false);
        heap.creat();
        System.out.println(heap.toString());
        int curr;
        while ((curr = heap.poll()) != -1) {
            System.out.print(curr + " ");
        }
    }
}
