package com.pandy.safety

fun main() {
    var a: String = "abc"
    a = null.toString()

    var b: String? = "abc"
    b = null

    val l = a.length

    //b非空 返回b.length 否则返回null
    val l2 = b?.length

    val listWithNulls: List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls){
        item?.let { println(it) }
    }

    //elvis表达式
    //val l3: Int = if (b != null) b.length else -1
    val l4 = b?.length ?: -1

    val c  = 1
    val aInt: Int? = c as? Int
}
