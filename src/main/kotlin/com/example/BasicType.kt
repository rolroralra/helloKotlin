package com.example

fun main() {
    val a = 1_000_000
    val b: Int? = 1_000_000

    println("a === b : ${a === b}")
    println("a == b : ${a == b}")


    val intVariable: Int = 100
    val longVariable: Long = intVariable.toLong()

    println("$intVariable, $longVariable")

    checkCharacter('a')

    val array: Array<String> = arrayOf("Kotlin", "Java", "NodeJs", "Go")

    println(array[2])
    array[2] = "Python"
    println(array[2])

    for (s in array) {
        println(s)
    }


    val array2 = Array(5) { i -> i.toString() }

    array2.forEach { str -> println(str) }


    val intArr: IntArray = intArrayOf(1,2,3,4,5)
    for (i in intArr) {
        println(i)
    }

    val str = "Kotlin"

    println(str[1])
    println(str.length)
    println(str)

    val s = """
        This is Kotlin raw String...
        "It is very good"
        ...
    """.trimIndent()
    println(s)
}

fun checkCharacter(c: Char) {
    if (c == 'a') {
        println(c.code)
    }
}

class BasicType {

}