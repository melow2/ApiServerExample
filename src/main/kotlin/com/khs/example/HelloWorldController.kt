package com.khs.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    // GET
    // /hello-world (endpoint)
    @GetMapping("/hello-world-bean")
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("test")
    }
}