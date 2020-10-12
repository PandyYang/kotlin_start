package com.pandy.inline

inline fun foo(block: () -> Unit) {
    println("before block")
    block()
    println("end block")
}

inline fun <reified T> getType() {
    print(T::class)
}

fun main() {
    foo {
        println("dive into kotlin")
    }
    getType<Int>()
}
