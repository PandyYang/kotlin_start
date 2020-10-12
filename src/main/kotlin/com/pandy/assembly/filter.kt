package com.pandy.assembly

/**
 * 过滤
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThen3 = numbers.filter { it.length > 3 }
    println(longerThen3)
    val numbersMap = mapOf("key" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filtersMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
    println(filtersMap)
    val filterIndexMap = numbers.filterIndexed { index, s -> index > 1 && s.length > 3 }
    println(filterIndexMap)
    val numbers2 = listOf(null, 1, "two", 3.0, "four")
    numbers2.filterIsInstance<String>().forEach {
        println(it.toUpperCase())
    }
    numbers2.filterNotNull().forEach {
        println(it)
    }

    //划分 将匹配的放在一个列表 将不匹配的放在另一个列表
    val(match, rest) = numbers2.partition { it is String }
    println(match)
    println(rest)

    println(numbers.any { it.endsWith("e") })
    println(numbers.none{ it.endsWith("a") })
    println(numbers.all { it.endsWith("a") })

    val empty = emptyList<String>()
    println(empty.none())
    println(empty.any())

    //加减操作
    println(numbers + "five")
    println(numbers - listOf("three", "four"))


}
