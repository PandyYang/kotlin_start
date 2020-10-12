package com.pandy.assembly

/**
 * 构造集合
 */

fun main() {
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
    val numbersMap2 = mutableMapOf<String, String>().apply { this["one"] = "1" }

    //映射生成转换结果列表
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed{idx, value -> value * idx})

    //关联生成map
    val numbers2 = listOf("one", "two", "three")
    println(numbers2.associateWith { it.length })
}
