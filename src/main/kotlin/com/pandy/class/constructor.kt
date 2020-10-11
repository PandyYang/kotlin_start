package com.pandy.`class`


/**
 * 可以有一个主构造函数以及多个次构造函数
 * 主构造函数是类名之后的一部分
 * 如果后面无注解或者可见性修饰符 那么可以省略
 */
class Person constructor(firstName: String) {

}

class Person2(firstName: String)

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also { println(it) }

    init {
        println("First initializer block that prints ${name.length}").also { println(it) }
    }

    val secondProperty = "Second property: ${name.length}".also { println(it) }

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

/**
 * 主构造函数的参数可以在初始化块中使用
 * 也可以在类体中生命的属性初始化中使用
 */
class Customer(name: String) {
    val customerKey = name.toUpperCase()
}

class Person3(val firstName: String, val lastName: String, val age: Int){
    /**
     *
     */
}

class Constructors {
    init {
        println("init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

