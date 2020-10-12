package com.pandy.metaprogram.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static <A> Map<String, Object> toMap(A a) {
        Field[] fs = a.getClass().getDeclaredFields();
        Map<String, Object> kvs = new HashMap<>();
        Arrays.stream(fs).forEach((f) -> {
            f.setAccessible(true);
            try {
                kvs.put(f.getName(), f.get(a));
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        });
        return kvs;
    }

}
