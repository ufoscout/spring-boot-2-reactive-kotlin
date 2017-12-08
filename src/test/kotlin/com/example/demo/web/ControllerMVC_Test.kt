package com.example.demo.web

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

@RunWith(SpringRunner::class)
@WebMvcTest(Controller::class)
class ControllerMVC_Test {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testHelloWorldMVC() {
        mockMvc.perform(
                get("/mvc")
        ).andExpect(
                content().string(Controller.MESSAGE)
        )
    }

}