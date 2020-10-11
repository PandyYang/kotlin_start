package com.pandy.new13

import java.lang.IllegalArgumentException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * 契约让一个函数能够以编译器理解的方式描述其行为
 */

fun foo(s: String?) {
    s?.length
}

fun String?.isNotNull(): Boolean = this != null

fun foo2(s: String?) {
    if (s.isNotNull()) s!!.length //提取到单独的函数中 无智能检测
}

@ExperimentalContracts
fun require(condition: Boolean) {
    //如果这个函数成功返回 传入的condition为true
    contract { returns() implies condition }
    if (!condition) throw IllegalArgumentException()
}

@ExperimentalContracts
fun synchronize(block: () -> Unit) {
    //函数会在此时此处调用block 并且刚好只调用一次
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
}

@ExperimentalContracts
fun foo3() {
    val x: Int
    synchronize() {
        x = 42
    }
    println(x)
}
