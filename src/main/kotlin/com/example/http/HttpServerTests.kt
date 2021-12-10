package com.example.http

fun main() {
    val httpServer = HttpServer(8090, 5)
    httpServer.open()
}

class HttpServerTests {
}