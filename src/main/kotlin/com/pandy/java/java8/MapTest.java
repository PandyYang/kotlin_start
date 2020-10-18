package com.pandy.java.java8;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {

    public Optional<Person> biggestNameLength(Stream<Person> personStream) {
        Function<Person, Long> getLength = person -> person.getName().chars().count();
        return personStream.max(Comparator.comparing(getLength));
    }

//    public Map<Boolean, List<Person>> isOld(Stream<Person> personStream) {
//        return personStream.collect()
//    }

//    public Map<Person, Long> lengthOfName(Stream<Person> personStream) {
//        return personStream.collect()
//    }


    protected String name;
    protected int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

public class MapTest {

    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    public static void main(String[] args) {
        List<String> collect = Stream.of("a", "b", "hello").map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = Stream.of("a", "1abc", "abc21").filter(value -> isDigit(value.charAt(0))).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> collect2 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect2);

        List<Person> people = Arrays.asList(new Person("Pandy", 22), new Person("Jamyun", 17), new Person("Bob", 12));
        int minAge = people.stream().min(Comparator.comparing(it -> it.age)).get().age;
        System.out.println(minAge);
        String collect4 = people.stream().map(Person::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(collect4);

        Integer reduce = Stream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        HashSet<Integer> integers = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> collect3 = integers.stream().sorted().collect(Collectors.toList());
        System.out.println(collect3);



    }
}
