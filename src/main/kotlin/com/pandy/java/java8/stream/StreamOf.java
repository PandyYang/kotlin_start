package com.pandy.java.java8.stream;

import java.util.stream.Stream;

public class StreamOf {
    public static void main(String[] args) {
        Stream.of("It's" + "a" + "wonderful" + "day"+ "for"+"pie!" )
                .forEach(System.out::println);

        Stream.of(1,2,3).forEach(System.out::println);
    }
}
