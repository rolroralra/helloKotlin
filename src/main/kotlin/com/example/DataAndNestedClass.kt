package com.example

import java.util.*
import kotlin.Comparator

fun main() {
    println(UserDetail("rolroralra", 20))
    println(UserDetail())
    println(UserDetail("test"))
    println(UserDetail(age = 99, name = "admin"))
    println(UserDetail(name= "guest"))

    println(NoDataClass())

    val userDetail = UserDetail(name="shawn", age=22)
    println(userDetail.copy(age=34))

    println(userDetail)
    println(userDetail.age)
    println(userDetail.name)


    // Destructuring Declarations from Data class
    // It is implemented by component1, component2 method.
    val (name, age) = UserDetail("Jane", 35)
    println("name=$name, age=${age + 3}")


    // Pair, Triple
    println(Pair(1, "A"))
    println(Triple(2, "B", 3.5))

    val pair = Pair(1, "A")
    println("${pair.first}, ${pair.second}")

    val triple = Triple(1, 2, 3)
    println("${triple.first}, ${triple.second}, ${triple.third}")

    val nestedClassInstance = Outer.Nested()
    println(nestedClassInstance.foo())

    val innerClassInstance = Outer().Inner();
    println(innerClassInstance.foo())


    val list = listOf(5,2,3,1,4)
    Collections.sort(list, object: Comparator<Int>{
        override fun compare(o1: Int, o2: Int): Int {
            return o1 - o2
        }
    })
    println(list)

    val list2 = List(5, list::get)
    println(list2)

    Collections.sort(list2) { o1, o2 -> o2 - o1 }
    println(list2)
}

// Data class cannot be abstract, open, sealed, inner.
// but Data class can be implemented some interface.
// toString, equals, hashCode, copy are automatically implemented.
data class UserDetail constructor(val name: String = "user", val age: Int = 0)

class NoDataClass constructor(val name: String = "user", val age: Int = 0)

class Outer {
    private val bar: Int = 1

    // Nested Class cannot access outer class's member
    class Nested {
        fun foo() = 2
//        fun foo2() = bar      // ERROR
    }

    // Inner Class can access outer class's member
    inner class Inner {
        fun foo() = bar
    }
}
