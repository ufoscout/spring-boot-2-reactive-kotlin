package com.example.demo.web

import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.reactor.mono
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Controller
class Controller {

    @GetMapping("/")
    fun helloWorld() = mono (Unconfined) {
        "Hello from Spring boot and coroutines"
    }

}