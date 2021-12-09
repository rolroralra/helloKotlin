package com.example.http

import org.jetbrains.annotations.TestOnly

fun main() {
    val httpServer = HttpServer(8090, 5)
    httpServer.open()

}

class HttpServerTests {
}