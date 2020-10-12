package com.pandy.assembly

/**
 * 分组
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.groupBy { it.first().toUpperCase() })

    //返回一个map 根据键进行分组 然后处理其中的值
    println(numbers.groupBy ( keySelector = {it.first()}, valueTransform = {it.toUpperCase()} ))
    println(numbers.groupingBy { it.first() }.eachCount())
}
