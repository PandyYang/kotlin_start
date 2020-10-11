package com.pandy.`class`

interface MyInterface {
    fun bar()
    fun foo() {
        //可选的方法体
    }
}


//一个类或者对象可以实现一个或多个接口
class Child: MyInterface {
    override fun bar() {
        TODO("Not yet implemented")
    }
}

interface MyInterface2 {
    val prop: Int

    val propertyWithImplementation: String
    get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child2: MyInterface2 {
    override val prop: Int
        get() = 29
}
