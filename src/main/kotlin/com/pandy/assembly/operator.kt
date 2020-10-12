package com.pandy.assembly

/**
 * 操作
 */

// to object
fun main() {
    val numbers = listOf("one", "two", "three")
    val filterResult = mutableListOf<String>()
    numbers.filterTo(filterResult) { it.length > 3}
    println(filterResult)
    val result = numbers.mapTo(HashSet()) { it.length}
    println("distinct item lengths are $result")
}
