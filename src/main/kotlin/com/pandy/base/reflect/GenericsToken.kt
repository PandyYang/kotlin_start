package com.pandy.base.reflect

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * 获取所有类型信息的泛型类
 */

open class GenericsToken<T> {
    var type: Type = Any::class.java
    init {
        val superClass = this.javaClass.genericSuperclass
        //type = (superClass as ParameterizedType).getActualTypeArguments()[0]
    }
}

fun main() {
    val gt = object : GenericsToken<Map<String, String>>() {}
    println(gt.type)
}
