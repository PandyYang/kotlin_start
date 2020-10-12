package com.pandy.metaprogram

import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties

data class User(val name:String, val age:Int)

object User2 {
    fun toMap(a: User): Map<String, Any> {
        return hashMapOf("name" to a.name, "age" to a.age)
    }
}

/*使用反射**/
object Mapper {
    fun <A: Any> toMap(a: A) = run {
        a::class.memberProperties.map { m ->
            val p = m as KProperty<*>
            p.name to p.call(a)
        }.toMap()
    }
}

fun main() {
    println(Mapper.toMap(User("Pandy",22)))
}
