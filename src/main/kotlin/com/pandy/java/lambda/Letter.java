package com.pandy.java.lambda;

import java.util.function.Function;

public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan:" + text;
    }

    public static String addFooter(String text){
        return text + "Kind regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("labda", "Lambda");
    }

    //使用andThen的转换流水线
    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
            .andThen(Letter::addFooter);
}
