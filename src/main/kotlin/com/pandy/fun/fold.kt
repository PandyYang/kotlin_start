package com.pandy.`fun`

/**
 * 接受一个初始累计值与一个接合函数
 * 并通过将当前累积值与每个集合元素连续接合起来代入
 * 累计值来构建返回值
 */

fun main() {
    val items = listOf(1,2,3,4,5)
    items.fold(0, {
        acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        result
    })

    val joinedToString = items.fold("Elements:", {
        acc, i ->
        "${acc.plus(i)} $i"
    })

    println(joinedToString)

    val product = items.fold(1, Int::times)

    println(product)
}
