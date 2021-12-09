package com.example

fun main() {
    val customer = Customer("kotlin")
    println(customer)
    println(customer.t)
    println(customer.name)

    println(Customer())

}

class Empty : Any()

// package kotlin
//public open class Any {
//    public open operator fun equals(other: Any?): Boolean
//    public open fun hashCode(): Int
//    public open fun toString(): String
//}

class Person constructor(firstName: String) {

}

class Person2(firstName: String) {
}

// field: name, t
data class Customer (var name: String) {
    var t: String = ""
        get() { return field }
        set(value) { field = value }

    init {
        t = name
    }

    constructor(t: String, name: String): this(name){
    }

    constructor(): this("rolroralra", "kotlin") {

    }
}

// Private Constructor
class DontCreateMe private constructor() {

}

class Class {
}