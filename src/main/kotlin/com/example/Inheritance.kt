package com.example

fun main() {
    println(Base(1))
    println(Derived(2))

    println(AA(1))
    val a = AA(1)
    println(a.x)
    a.x = 2
    println(a.x)
    println(BB(2))

    val b = BB(3)
    println(b.x)
    println(if (b is AA) b.javaClass.simpleName else "")

    val based = Base(1)
    val derived = Derived(2)
    based.v()
    derived.v()

    val cc = C()
    cc.a()
    cc.f()
    cc.b()

    val user = User("rolroralra")
    user.age = 10
    println(user)
    println(user.name)
    println(user.age)

    println(User("test", 12))
}


//  Class = Class Name + Class Header + Class Body
open class Base(p: Int) {
    init {
        println("${this.javaClass.simpleName}($p)")
    }

    open fun v() {
        println("called ${this.javaClass.simpleName}.v")
    }
}

class Derived(p: Int): Base(p) {
    override fun v() {
        println("called Derived function")
    }
}

// open : acceptable to inheritance (cf. final)
open class AA(var x: Int)

class BB(x: Int): AA(x)

class Member(var name: String) {
}

open class View(var name: String) {

}
class MyView: View {
    constructor() : super("MyView")
    constructor(ctx: Int) : this()
    constructor(ctx: Int, attrs: Int) : this(ctx)
}

open class A {
    open fun f() {
        println("A.f() called")
    }

    fun a() {
        println("A.a() called")
    }
}

interface B {
    fun f() {
        println("B.f() called")
    }
    fun b()
}

class C : A(), B {
    override fun f() {
//        super<A>.f()
        super<B>.f()
    }

    override fun b() {
        println("C.b() called")
    }
}

// abstract class, interface are always open.
abstract class AbsClass {
    abstract fun f()
}

class MyClass constructor(): AbsClass() {
    override fun f() {
        println("MyClass.f() called")
    }
}

data class User constructor(var name: String) {
    var age: Int = 0
        get() = field
        set(value) {field = value}

    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }
}