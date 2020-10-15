package com.pandy.java.generic;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class Generic {

    /**
     * 逆变 代表一个具体类型 这个类型是Apple的超类
     * 既然？ super Apple 说明Apple作为超类
     * 向其中添加子类 可以是安全的
     * @param apples
     */
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Fruit());
    }

    /**
     * extends是限制数据来源的生产者 extends  get    本身以及子类
     * super是限制数据流入的消费者   super    add    本身以及父类
     * @param apples
     */
    static void readFrom(List<? extends Apple> apples) {
        Apple apple = apples.get(0);
//        Jonathan jonathan = apples.get(0);
        Fruit fruit = apples.get(0);
    }

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            fruits[0] = new Fruit();
        }catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[0] = new Orange();
        }catch (Exception e) {
            System.out.println(e);
        }

        /**
         * 协变
         * extends 指出了泛型的上界为fruit
         */
        List<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());

    }
}
