package com.example

import io.micronaut.core.version.annotation.Version
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

class HelloWorld {
    @Version("1")
    @Controller("/hello")
    class HelloWorldController{
        @Get
        fun hello() = "Hello Word!"
    }
}
