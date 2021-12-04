package com.example

fun main(args: Array<String>) {
    println(max(1,2,3,4,5, -1))
    println(min(-1, 3))
    println(min(4, 2))
    print(1)
    print("?")
    print(listOf<Int>())
    print(Any())
    print(true)

    println(parseScore(100))
    println(parseScore(79))
    println(parseScore(50))
    pickRandomLottoByCurrTime()
}

fun max(vararg n :Int): Int {
    var max = Int.MIN_VALUE

    for (i in n) {
        if (i > max)
            max = i
    }

    return max
}

fun max(a: Int, b: Int): Int = if (a < b) b else a

fun min(a: Int, b: Int): Int =
    if (a < b) {
        println("$a < $b")
        a
    } else {
        println("$a >= $b")
        b
    }

fun parseScore(score: Int): String = when(score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    else -> "F"
}

fun print(a: Any) {
    when(a) {
        is Number -> {
            println("Number $a")
        }
        is String -> println("""String $a""")
        is Array<*>, is List<*>, is Collection<*> -> println("Collection $a")
        else -> {
            println("Any $a")
        }
    }
}

fun print(b: Boolean) {
    when(b) {
        true -> println("True")
        false -> println("False")
    }
}

fun pickRandomLottoByCurrTime() {
    val remainTime = System.currentTimeMillis() % 100
    when {
        remainTime < 50 -> println("50 Down")
        else -> println("50 Up")
    }
}

class Condition {


}