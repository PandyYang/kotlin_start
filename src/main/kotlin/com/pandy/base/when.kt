package com.pandy.base

fun describe(obj: Any): String =
    when(obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a String"
        else       -> "Unknown"
    }
