package com.example

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class OpenApiTest(@Client("/") private val httpClient: HttpClient) : ShouldSpec({

    should("serve OpenApi specification") {
        val getRequest = HttpRequest.GET<Any>("/swagger/micronaut-swaggerui-demo-1.0.0.yml")
        val response = httpClient.toBlocking().exchange(getRequest, String::class.java)

        response.status shouldBe HttpStatus.OK
        response.body() shouldStartWith "openapi: 3."
    }
})
