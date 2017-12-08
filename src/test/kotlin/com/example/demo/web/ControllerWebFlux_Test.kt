package com.example.demo.web

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebFluxTest(Controller::class)
class ControllerWebFlux_Test {

    @Autowired
    lateinit var webTestClient: WebTestClient

    /*

    DOES NOT COMPILE DUE TO KOTLIN BUG. See here:
    https://youtrack.jetbrains.com/issue/KT-5464
    https://jira.spring.io/browse/SPR-15692

    To be fixed in Kotlin 1.3

    @Test
    fun testHelloWorldWebFlux() {

        webTestClient.get()
                .uri("/webflux")
                .exchange()
                .expectStatus().isAccepted()
                .expectBody<String>(ControllerWebFlux.MESSAGE)

    }
     */

    @Test
    fun testDoNothing() {
    }
    
}
