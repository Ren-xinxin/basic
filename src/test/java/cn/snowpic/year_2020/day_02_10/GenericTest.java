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
}
