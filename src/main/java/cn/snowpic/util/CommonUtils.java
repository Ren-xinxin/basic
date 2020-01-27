/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.util;

import java.util.*;
import java.util.stream.Collectors;

public class CommonUtils {

    /**
     * permute
     *
     * @author lf
     * @time 2020-01-20 20:39
     * @param origin origin
     * @param step step
     * @param tepContainer tep container
     * @param book book
     * @param result result
     */
    private static void permute(final List<Integer> origin, int step, List<Integer> tepContainer, Set<Integer> book, List<List<Integer>> result) {
        // whether there a compete number permute
        if (tepContainer.size() == step) {
            // put current permute into the result
            result.add(new ArrayList<>(tepContainer));
            // return last node to find another chance
            return;
        }
        // traverse the origin
        for (int i = 0; i < origin.size(); i++) {
            // whether the index was marked
            if (book.add(i)) {
                // get current value
                Integer currentValue = origin.get(i);
                // add current value to the tep container
                tepContainer.add(currentValue);
                // recursive the method to find the next value index
                permute(origin, step, tepContainer, book, result);
                // remove the mark when call back
                book.remove(i);
                // remove the current value from the tep container
                tepContainer.remove(currentValue);
            }
        }
    }

    /**
     * permute
     *
     * @author lf
     * @time 2020-01-20 20:49
     * @param origin origin
     * @param step step
     * @return @List<List<Integer>>
     */
    public static List<List<Integer>> permute(int[] origin, int step) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> collected = Arrays.stream(origin)
                .boxed()
                .collect(Collectors.toList());
        permute(collected, step, new ArrayList<>(), new HashSet<>(), result);
        return result;
    }
}
