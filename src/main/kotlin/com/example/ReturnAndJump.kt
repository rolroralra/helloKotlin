package com.example

fun main() {
    labelBreak()
    println()
    labelContinue()
    println()
    labelReturn()
}

fun labelBreak() {
    loop@ for (i in 1..10) {
        println("i: $i")

        for (j in 1..10) {
            if (i + j > 12) {
                break@loop
            }
            println("j: $j")
        }
    }
}

fun labelContinue() {
    loop@ for (i in 1..10) {
        println("i: $i")

        for (j in 1..10) {
            if (j < 2) {
                continue@loop
            }
            println("j: $j")
        }
    }
}

fun labelReturn() {
    val ints = arrayOf(0,1,2,3,4)

    ints.forEach customFuncLabel@ {
        if (it == 1) {
            return@customFuncLabel
//            return@forEach
        }

        println(it)
    }
}

class ReturnAndJump {
}