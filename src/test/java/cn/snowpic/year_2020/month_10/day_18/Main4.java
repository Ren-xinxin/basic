/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main4 {
    private static class Book {
        private int l;
        private int w;
        private Book top;
        private Book bottom;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        final Book b1 = new Book();
        final Book b2 = new Book();
        final Book b3 = new Book();

        b1.l = 2;
        b1.w = 3;

        b2.l = 3;
        b2.w = 4;

        b3.l = 1;
        b3.w = 6;

        books.add(b1);
        books.add(b2);
        books.add(b3);

        for (Book curr : books) {
            for (Book neighbour : books) {
                setNeighbours(curr, neighbour);
            }
        }

        int depth = -1;

        AtomicInteger counter = new AtomicInteger();
        for (Book book : books) {
            counter.set(1);
            getDepth(book, counter, true);
            getDepth(book, counter, false);
            if (counter.get() > depth) {
                depth = counter.get();
            }
        }
        System.out.println(depth);
    }

    private static void setNeighbours(Book curr, Book neighbour) {
        if (neighbour.l > curr.l && neighbour.w > curr.w) {
            if (curr.top == null) {
                curr.top = neighbour;
            } else {
                setNeighbours(curr.top, neighbour);
                setNeighbours(curr.bottom, neighbour);
            }
        }
        if (neighbour.l < curr.l && neighbour.w < curr.w) {
            if (curr.bottom == null) {
                curr.bottom = neighbour;
            } else {
                setNeighbours(curr.top, neighbour);
                setNeighbours(curr.bottom, neighbour);
            }
        }
    }

    private static void getDepth(Book curr, AtomicInteger count, boolean isTop) {
        if (isTop){
            if (curr.top != null) {
                count.getAndIncrement();
                getDepth(curr.top, count, true);
            }
        }else {
            if (curr.bottom != null) {
                count.getAndIncrement();
                getDepth(curr.bottom, count, false);
            }
        }
    }
}