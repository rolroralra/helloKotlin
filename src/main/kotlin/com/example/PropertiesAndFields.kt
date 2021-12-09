package com.example

import java.lang.AssertionError

fun main() {
    val address = Address()
    println(address)
    println(address.name)
    address.name = "Java"
    println(address.name)
    println(address.isEmpty)
    address.add()
    println(address.isEmpty)

    val address2 = Address2()
    println(address2.table)

    // @Deprecated(val message: String, val replaceWith: ReplaceWith, val deprecationLevel DeprecationLevel)
    foo()
    val test = MyTest()
    test.setUp()
    println(test.mockBean)
    println(test.setUp())
}

class Address {
    var name: String = "Kotlin"
        get() { return "$field?!" }
        set(value) { field = value }    // Backing Field : field

    var allByDefault: Int? = null
    var age: Int = 0
        private set
    var size: Int = 0

    val isEmpty: Boolean            // Not Making Backing Field
        get() { return size == 0}

    fun add() {
        size++
    }
}

class Address2 {
    private var _table: Map<String, Int>? = null    // Backing Property
    val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
            }

            return _table ?: throw AssertionError("Null Pointer Exception")
        }
}


// Compile Time Constant (const)
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
const val SUBSYSTEM_REPLACEMENT: String = """println("foo called")"""

// Compile Time Constant can use in Annotation. (@Deprecated)
@Deprecated(SUBSYSTEM_DEPRECATED, ReplaceWith(SUBSYSTEM_REPLACEMENT), DeprecationLevel.WARNING)
fun foo() {
    println("foo called")
}

// Late Initialized Properties (lateinit)
class MyTest {
    lateinit var mockBean: String

    fun setUp() {
        mockBean = "mockBean"
    }
}



