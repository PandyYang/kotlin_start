package com.pandy.base

abstract class Array<T> private constructor() {
    abstract val size: Int
    abstract operator fun get(index: Int): T
    abstract operator fun set(index: Int, value: T): Unit
    abstract operator fun iterator(): Iterator<T>
}

fun main() {
    val asc = Array(5) {i -> (i*i).toString() }
    asc.forEach { print(it) }

    val arr = IntArray(5) //[0,0,0,0,0]
    val arr2 = IntArray(5) {42} //[42,42,42,42,42]
    val arr3 = IntArray(5) {it*1} //[0,1,2,3,4]
}
