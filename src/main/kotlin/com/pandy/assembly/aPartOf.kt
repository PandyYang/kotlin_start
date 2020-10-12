package com.pandy.assembly

/**
 * 取集合的一部分
 */

fun main() {
    //slice
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3,5,0)))

    //take & drop
    println(numbers.take(3))
    println(numbers.takeLast(3))

    //使用谓词定义想要获取或者去除的元素的数量
    println(numbers.takeWhile { !it.startsWith("f") })
    println(numbers.takeLastWhile { it != "three" })

    //chunked
    val numbers2 = (0..13).toList()
    println(numbers2.chunked(3) { it.sum() })

    println(numbers2.windowed(3, partialWindows = true))



}
