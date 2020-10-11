package com.pandy.base

fun main() {

    var items = listOf("a", "b", "c")

    for (item in items) {
        println(item)
    }

    //in 运算符来判断集合内是否包含某实例
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    //使用lambda表达式过滤与映射集合
    val fruits = listOf("banana", "apple", "avocado", "kiwifruit")
    fruits.filter {
        it.startsWith("a")
    }.sortedBy {
        it
    }.map {
        it.toUpperCase()
    }.forEach {
        println(it)
    }
}
