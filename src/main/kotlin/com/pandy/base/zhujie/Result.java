package com.pandy.base.zhujie;

public class Result {
    public static void main(String[] args) {
        /**
         * 使用反射 获取注解修饰的类
         * 方法一：  。class
         * 方法二：  Class.forName()
         * 方法三：  getClass
         */
        Class<Test> testClass = Test.class;
        /**
         * 获取修饰类上的注解信息
         */
        Yun annotation = testClass.getAnnotation(Yun.class);
        /**
         * 打印注解值
         */
        System.out.println(annotation.Value());
    }
}
