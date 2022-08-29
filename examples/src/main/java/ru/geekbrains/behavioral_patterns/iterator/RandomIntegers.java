package ru.geekbrains.behavioral_patterns.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomIntegers implements Iterable<Integer> {

    private final List<Integer> integerList;

    public RandomIntegers(int count) {
        integerList = new Random().ints(count, 0, 1000)
                                  .boxed()
                                  .collect(Collectors.toList());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Integer> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < integerList.size();
        }

        @Override
        public Integer next() {
            return integerList.get(cursor++);
        }
    }

}
