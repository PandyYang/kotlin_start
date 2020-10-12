package com.pandy.assembly

/**
 * 迭代
 */

fun main() {
    val numbers = listOf("one", "two", "three")
    val numberIterable = numbers.iterator()
    while (numberIterable.hasNext()) {
        println(numberIterable.next())
    }
}
