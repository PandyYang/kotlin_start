package com.pandy.base

fun main() {

    //使用in 运算符检测某个数字是否在指定区间之内
    val x = 10
    val y = 9
    if (x in 1.. y+1){
        println("fits in range")
    }

    //检测某个数字是否在指定区间外
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    //区间迭代
    for (x in 1..5) {
        print(x)
    }

    //数列迭代
    for (x in 1..10 step 2) {
        println(x)
    }

    for (x in 9 downTo 0 step 3) {
        println(x)
    }

}
