package ru.geekbrains.behavioral_patterns.iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Iterable<String> strings = new Iterable<>() {

            @Override
            public Iterator<String> iterator() {
                return new Iterator<>() {

                    String[] arr = {"first", "second", "third"};

                    int current = 0;

                    @Override
                    public boolean hasNext() {
                        return current < arr.length;
                    }

                    @Override
                    public String next() {
                        return arr[current++];
                    }
                };
            }
        };

        for (String str : strings) {
            System.out.println(str);
        }

        RandomIntegers randomIterator = new RandomIntegers(10);
        for (Integer integer : randomIterator) {
            System.out.println(integer);
        }


        RandomIntegersIterator randomIntegersIterator = new RandomIntegersIterator(10);
        for (Integer integer : randomIntegersIterator) {
            System.out.println(integer);
        }

    }
}
