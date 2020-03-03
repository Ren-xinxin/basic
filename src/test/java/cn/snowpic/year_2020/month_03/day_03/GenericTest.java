/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-03-03 09:06:34
 */
public class GenericTest {

    /**
     * minimum rabbit number
     *
     * @author lf
     * @time 2020-03-03 09:08:43
     * @param sameColorNumbers same color numbers
     * @return int
     */
    private int minimumRabbitNumber(int[] sameColorNumbers) {
        Map<Integer, List<Rabbit>> map = new HashMap<>();
        for (int number : sameColorNumbers) {
            List<Rabbit> rabbits = map.get(number);
            rabbits = rabbits == null ? new ArrayList<>() : rabbits;
            Rabbit lastRabbit = rabbits.size() == 0 ? null : rabbits.get(rabbits.size() - 1);
            if (lastRabbit == null || lastRabbit.isFull()) {
                Rabbit rabbit = new Rabbit(number);
                rabbits.add(rabbit);
            } else {
                lastRabbit.increaseNumber();
            }
            map.put(number, rabbits);
        }
        return map.values().stream()
                .map(GenericTest::mapToSum)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * map to sum
     *
     * @author lf
     * @time 2020-03-03 19:43:44
     * @param rabbits rabbits
     * @return int
     */
    private static int mapToSum(List<Rabbit> rabbits) {
        return rabbits.stream()
                .map(Rabbit::getCapacity)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * rabbit
     *
     * @className Rabbit
     * @author lf
     * @time 2020-03-03 19:43:50
     */
    private static class Rabbit {

        private final int capacity;

        private int realNumber;

        Rabbit(int otherNumber) {
            this.capacity = otherNumber + 1;
            this.realNumber = 1;
        }

        boolean isFull() {
            return realNumber >= capacity;
        }

        void increaseNumber() {
            if (isFull()) {
                throw new RuntimeException("Rabbit container is full.");
            }
            realNumber++;
        }

        int getCapacity() {
            return capacity;
        }
    }

    @Test
    public void test1() {
        int[] input = {1, 1, 2};
        int rabbitNumber = minimumRabbitNumber(input);
        System.out.println("rabbitNumber = " + rabbitNumber);
    }
}
