package com.example.http

import java.net.Socket

interface IHttpServer {
    fun open()
    fun handle(socket: Socket)
    fun close()
}