### Kotlin
[https://kotlinlang.org/](https://kotlinlang.org/)

---
### if-else
<details>
  <summary>Details</summary>
  <p>

```kotlin
fun main() {
  println(max(1,2,3,4,5,-1))  
  // 5
  
  println(min(-1, 3))
  // -1 < 3
  // -1
    
  println(min(4, 2))
  // 4 >= 2
  // 2
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
```
  </p>
</details>

---
## when (cf. swtich)
<details>
  <summary>Details</summary>
  <p>

```kotlin
fun main() {
    print(1)
    print("?")
    print(listOf<Int>())
    print(Any())
    print(true)
    
    println(parseScore(100))
    println(parseScore(79))
    println(parseScore(50))
    pickRandomLottoByCurrTime()
    
/*    
    Number 1
    String ?
    Collection []
    Any java.lang.Object@4f3f5b24
    True
    A
    C
    F
    50 Up 
*/
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

fun parseScore(score: Int): String = when(score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    else -> "F"
}

fun pickRandomLottoByCurrTime() {
    val remainTime = System.currentTimeMillis() % 100
    when {
        remainTime < 50 -> println("50 Down")
        else -> println("50 Up")
    }
}

```
  </p>
</details>

---
# break, continue, return with label
 <details>
  <summary>Details</summary>
  <p>

```kotlin
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
```
  </p>
</details>
    