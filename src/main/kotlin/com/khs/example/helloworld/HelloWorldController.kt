package com.khs.example.helloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    // GET
    // /hello-world (endpoint)
    @GetMapping("/hello-world-bean")
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("test")
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    fun hellWorldBean(@PathVariable name:String): HelloWorldBean {
        return HelloWorldBean(String.format("Hello World, %s",name))
    }
}