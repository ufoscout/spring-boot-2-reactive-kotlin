package com.example.demo.web

import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.reactor.mono
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/hello")
    fun helloWorld() = mono (Unconfined) {
        MESSAGE
    }

    companion object {
        val MESSAGE = "Hello from reactive spring"
    }

}