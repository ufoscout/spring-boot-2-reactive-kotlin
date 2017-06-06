package com.example.demo.controller

import com.mongodb.reactivestreams.client.MongoClient
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.reactive.awaitFirst
import kotlinx.coroutines.experimental.reactor.mono
import kotlinx.coroutines.experimental.runBlocking
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

/**
 * Created by ufo on 06/06/17.
 */
@RestController
class ReactiveController {

    val databaseName = "DATABASE"
    val collection = "messages"

    @Autowired
    lateinit var mongo: MongoClient;

    @PostConstruct
    fun init() {
        runBlocking <Unit> {
            mongo
                    .getDatabase(databaseName)
                    .getCollection(collection)
                    .insertOne(Document().append("id", "0").append("message", "hello"))
                    .awaitFirst();
        }

    }

    @GetMapping("/message/{messageId}")
    fun getMessages(@PathVariable messageId: String) = mono(Unconfined) {
        val document = mongo
                .getDatabase(databaseName)
                .getCollection(collection)
                .find(Document().append("id", messageId))
                .awaitFirst();
        document
    }

}