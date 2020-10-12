package com.pandy.assembly

/**
 * 序列
 */

fun main() {
    // by iterable
    println("===================================================")
    val words = "the quick brown fox jumps over the lazy dog".split(" ")
    val lengthList = words.filter {
        println("filter: $it")
        it.length > 3
    }.map {
        println("length: ${it.length}")
        it.length
    }.take(4)
    println("Length of first 4 words longer then 3")
    println(lengthList)

    //by sequence just do when create list
    println("====================================================")
    val words2 = "the quick brown fox jumps over the lazy dog".split(" ")
    val wordSequence = words2.asSequence()
    val lengthSequence = wordSequence.filter {
        println("filter: $it")
        it.length > 3
    }.map {
        println("length: ${it.length}")
        it.length
    }.take(4)
    println("length of first 4 words longer then 3")
    println(lengthSequence.toList())
}
