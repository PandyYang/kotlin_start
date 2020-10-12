package com.pandy.assembly

/**
 * 范围
 */

fun main() {
    for (i in 4 downTo 1 step 2){
        println(i)
    }
    for (i in 1..4 step 2){
        println(i)
    }
    for (i in 1 until 4){
        println(i)
    }
    for (i in 1..9 step 3){
        println(i)
    }
}
