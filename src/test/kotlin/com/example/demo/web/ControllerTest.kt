package com.example.demo.web

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.reactive.function.client.WebClient
import reactor.test.test

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {

    @LocalServerPort private var port: Int = 0

    // TODO Migrate to WebTestClient when https://youtrack.jetbrains.com/issue/KT-5464 will be fixed
    //private val client = WebClient.create("http://localhost:$port")

    @Test
    fun testHelloWorldWebFlux() {

        val client = WebClient.create("http://127.0.0.1:$port")

        client.get().uri("/hello")
                .retrieve()
                .bodyToMono<String>(String::class.java)
                .test()
                .consumeNextWith {
                    Assert.assertEquals(Controller.MESSAGE, it)
                }.verifyComplete()

    }

}
