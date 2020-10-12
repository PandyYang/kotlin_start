package com.pandy.base.zhujie;

import java.lang.annotation.*;

/**
 * 创建自定义注解
 */

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Yun {
    String Value();
}
