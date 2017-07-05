package com.example.demo.controller

import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.reactive.publish
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello/{name}")
    fun get(@PathVariable name: String) = publish(Unconfined) {send("Hello, $name")}

}