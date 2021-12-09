package com.example.http

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class HttpServer(private val port: Int, private val nThreads: Int) : IHttpServer {
    private lateinit var serverSocket: ServerSocket
    private lateinit var executorService: ExecutorService
    private var isRunning = false

    override fun open() {
        serverSocket = ServerSocket(port)
        executorService = Executors.newFixedThreadPool(nThreads)
        isRunning = true

        println("[${Thread.currentThread()}] Server Opened...")
        var future = executorService.submit {
            while(isRunning) {
                val clientSocket = serverSocket.accept()
                executorService.submit {
                    handle(clientSocket)
                }
            }
        }

        executorService.submit {
            while (isRunning) {
//                println("[${Thread.currentThread()}] Command: ")
                val input = readLine()
                if ("QUIT".equals(input, true)) {
                    isRunning = false
                    future.cancel(false)
                    close()
                }
            }
        }
    }

    override fun handle(clientSocket: Socket) {
        println("[${Thread.currentThread()}] Request Received ${clientSocket.remoteSocketAddress}")

        val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        val output = PrintWriter(clientSocket.getOutputStream(), false)

        lateinit var str: String

        str = input.readLine()
        while (str.isNotEmpty()) {
            println("[${Thread.currentThread()}] $str")

            str = input.readLine()
        }

        val requestBody = StringBuilder()
        while (input.ready()) {
            requestBody.append(input.read().toChar())
        }
        println("[${Thread.currentThread()}] $requestBody")

//        println()
//        print("[${Thread.currentThread()}] Input HTTP Response Body: ")
//        val responseBody = readLine()
        val responseBody = requestBody.toString()

        output.print("HTTP/1.1 200 OK\r\n")
        output.print("Content-Type: application/json\r\n")
        output.print("Content-Length: ${responseBody?.length ?: 0 }\r\n")
        output.print("\r\n")
        output.print("$responseBody\n\r\n")
        output.flush()

        input.close()
        output.close()
        clientSocket.close()

        println("[${Thread.currentThread()}] ${clientSocket.remoteSocketAddress} Response Completed")
    }

    override fun close() {
        executorService.shutdownNow()
        serverSocket.close()

        println("[${Thread.currentThread()}] Server Closed...")
    }
}