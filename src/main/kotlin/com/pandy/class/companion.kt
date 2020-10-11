package com.pandy.`class`

/**
 * 类内部的对象声明可以用companion关键字标记
 */
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}


val instance = MyClass.create()

//可以省略伴生对象的名称
class MyClass2 {
    companion object {}
}

val x = MyClass2.Companion
