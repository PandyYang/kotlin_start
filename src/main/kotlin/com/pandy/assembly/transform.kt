package com.pandy.assembly

/**
 * 转换
 */

fun main() {
    val numbers = setOf(1,2,3)
    println(numbers.map { it * 3 })

    //将索引作为参数转换 第一个默认时index  第二个默认是value
    println(numbers.mapIndexed{value, idx -> idx + value*2})

    //过滤掉null值
    println(numbers.mapNotNull { if (it == 2) null else it * 3 })
    val numbersMap = mapOf("key" to 1, "key2" to 2, "key3" to 3)

    //可以转换键或者值 使对方保持不变
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })

    //双路转换
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)
    //不匹配的部分将会被丢弃
    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))
    //带有两个参数的转换函数来调用zip()
    println(colors.zip(animals) {color, animal -> "the ${animal.capitalize()} is $color"})
    //可以对元组的list 进行反向转换
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3)
    println(numberPairs.unzip())

    //关联 原始集合的元素是键 通过给定的转换函数从中产生值
    val numbers2 = listOf("one", "two", "three", "four")
    println(numbers2.associateWith { it.length })
    //根据元素的值 返回键
    println(numbers2.associateBy { it.first().toUpperCase() })
    //指定键值 通过其中的函数
    println(numbers2.associateBy ( keySelector = {it.first().toUpperCase()}, valueTransform = {it.length} ))
    val names = listOf("JayChou", "Quinlivan", "Pandy", "yunJam")
    //println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })
    //println(names.associate { name -> parseFullName(name).let {it.lastName to it.firstName} })

    //打平
    val numberSets = listOf(setOf(1,2,3), setOf(4,5,6), setOf(1,2))
    println(numberSets.flatten())
    //flatMap 返回单个列表其中包含所有元素的值

    val numbers3 = listOf("one", "two", "three", "four")
    println(numbers3)
    println(numbers3.joinToString())
    val listString = StringBuffer("The list of numbers:")
    // join to将元素追加到末尾
    numbers3.joinTo(listString)
    println(listString)

    //构建自定义字符串
    println(numbers.joinToString(separator = "|", prefix = "start:", postfix = "end"))

    val numbers4 = (1..100).toList()
    println(1..100)
    println(numbers4.joinToString(limit = 10, truncated = "<..>"))
    //该函数会作用到列表中的每一个元素上
    println(numbers3.joinToString { "Element: ${it.toUpperCase()}" })
}
