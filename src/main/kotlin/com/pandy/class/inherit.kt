package com.pandy.`class`

open class Shape{
    open fun draw() {

    }

    fun fill() {

    }
}

class Circle(): Shape() {
    override fun draw() {
        super.draw()
    }
}


open class Rectangle(): Shape() {
    //禁止再次覆盖
    final override fun draw() {
        super.draw()
    }
}

open class Class1{
    open fun draw() {}
}

interface Polygon {
    fun draw(){}
}

//解决菱形继承问题
class Square(): Class1(), Polygon {
    override fun draw() {
        super<Class1>.draw()
        super<Polygon>.draw()
    }
}
