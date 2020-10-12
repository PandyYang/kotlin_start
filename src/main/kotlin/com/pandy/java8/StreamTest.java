package com.pandy.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 34, 44, 2, 22, 2);
        numbers.stream().filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 600, Dish.Type.OTHER),
                new Dish("french fries", true, 500, Dish.Type.OTHER),
                new Dish("rice", true, 400, Dish.Type.OTHER),
                new Dish("season fruit", false, 300, Dish.Type.OTHER),
                new Dish("pizza", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(vegetarianDishes);

        //使用limit进行截断
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(dishes);

        //使用takeWhile对无限流进行操作

        //跳过元素
        List<Dish> dishes1 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(dishes1);

        //对流中的每一个元素应用函数
        List<String> dishName = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishName);

        List<String> words = Arrays.asList("1","12","123","1234","12345");
        List<Integer> wordLength = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLength);

        //每道菜的名称长度
        List<Integer> dishNameLength = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLength);

        //流的扁平化
        String[] arrOfWords = {"Hello", "World"};
        java.util.stream.Stream<String> words2 = Arrays.stream(arrOfWords);

        //测验5.2
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = numbers2.stream()
                .map(it -> it * it)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> num1 = Arrays.asList(1,2,3);
        List<Integer> num2 = Arrays.asList(4,5);
        List<int[]> collect1 = num1.stream()
                .flatMap(
                        i -> num2.stream()
                        .map(j -> new int[]{i, j})
                ).collect(Collectors.toList());
        System.out.println(collect1);

        //查找与匹配
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is yes");
        }

        if (menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("yes");
        }

        Optional<Dish> any = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(any);

        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> first = someNumbers.stream().map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(first);

        //归约
        Integer reduce = someNumbers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        Optional<Integer> reduce1 = someNumbers.stream().reduce(Integer::max);
        Optional<Integer> reduce2 = someNumbers.stream().reduce(Integer::min);
        System.out.println(reduce1);
        System.out.println(reduce2);

        Integer reduce3 = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        System.out.println(reduce3);

        //菜单的热量
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);

        //映射到数值流
        int calories2 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories2);

        //将原始流转换为一般流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        java.util.stream.Stream<Integer> boxed = intStream.boxed();

//        int a = 3;
//        java.util.stream.Stream<int[]> stream = IntStream.rangeClosed(1, 100)
//                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                .boxed()
//                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});

        //生成勾股数
        java.util.stream.Stream<int[]> stream1 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        stream1.limit(5).forEach(t ->
                System.out.println(t[0] + "," + t[1] +"," + t[2]));

        int[] numbers3 = {2, 3, 4, 5, 6, 7 ,11};
        int sum = Arrays.stream(numbers3).sum();

        //处理文件生成的流
        long uniqueWords = 0;
        try {
            java.util.stream.Stream<String> lines = Files.lines(Paths.get(""), Charset.defaultCharset());
            long count = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        }catch (IOException e){

        }

        //构建斐波那契数列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println(t[0] + "," + t[1]));

    }
}
