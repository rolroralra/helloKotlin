package com.example

fun main(args: Array<String>) {

    val N = 1041
    val nBinaryString = N.toString(2)

    var binaryGap = 0
    var startIndex = 0
    do {
        val endIndex = nBinaryString.indexOf('1', startIndex, true)
        val newBinaryGap = endIndex - startIndex

        binaryGap = if(binaryGap < newBinaryGap) newBinaryGap else binaryGap

        startIndex = endIndex + 1
    } while (endIndex != -1)

    println("Binary Gap : $binaryGap")
    println(N.toString(2))

    println(args.size)
    println("Hello Kotlin!")
    println(sum(1, 2))
    voidFunc()
    testVariable()
    testStringInterpolation()
    println(maxOf1(10 ,5))
    println(maxOf2(10, 5))
    println(maxOf3(10 , 5))
    printMultiplication("10", "5")
    printMultiplication("10", "x")

    println(getStringLength("1234"))
    println(getStringLength(1234))

    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    println()

    val mutableItems = mutableListOf("apple", "banana", "kiwi")
    val it = mutableItems.iterator()
    while (it.hasNext()) {
        println(it.next())
        it.remove()
    }

    val fruits = listOf("banana", "apple", "avocado", "kiwi")

    println()
    fruits.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }

    println(mutableItems.size)

    println(describe(1))
    println(describe("Hello"))
    println(describe(1L))
    println(describe(Unit))
    println(describe("String"))

    println(isInRange(3, 2, 10))
    printRange(3, 10)

}

fun printRange(min: Int, max: Int) {
    for (x in min..max) {
        print(x)
    }
}

//fun sum(a: Int, b: Int): Int {
//    return a + b
//}

fun sum(a: Int, b: Int) = a + b

fun voidFunc() {
    println()
}

fun testVariable() {
    val a: Int = 1
    val b = 2
    val c: Int

    var x = 5
    x += 1

    println(a)
    println(b)
    println(x)
}

// 문자열 보간법
fun testStringInterpolation() {
    var a = 1
    var s1 = "a is $a"

    println(s1)

    a = 2

    var s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

fun maxOf1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
fun maxOf2(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun maxOf3(a: Int, b: Int): Int = if (a > b) a else b


fun parseInt(arg: String) : Int? {
    return arg.toIntOrNull()
}

fun printMultiplication(arg1: String, arg2: String) {
    val x: Int? = parseInt(arg1)
    val y: Int? = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }

    return null
}

fun describe(obj: Any): String =
    when (obj) {
        1           -> "One"
        "Hello"     -> "Greeting"
        is Long     -> "Long"
        !is String  -> "Not a string"
        else        -> "Unknown"
    }

fun isInRange(x: Int, min: Int, max: Int): Boolean = x in min..max


class Test {

}