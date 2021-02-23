package com.khs.example.helloworld

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HelloWorldController {
    // GET
    // /hello-world (endpoint)
    @Autowired
    private lateinit var messageSource: MessageSource

    @GetMapping("/hello-world-bean")
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("test")
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    fun hellWorldBean(@PathVariable name:String): HelloWorldBean {
        return HelloWorldBean(String.format("Hello World, %s",name))
    }

    // FileEncoding -> UTF-8 설정해야 함.
    @GetMapping("/hello-world-internationlized")
    fun helloWorldInternationalized(@RequestHeader("Accept-Language",required = false) locale: Locale?): String {
        return if(locale==null) messageSource.getMessage("greeting.message",null,Locale.getDefault())
        else messageSource.getMessage("greeting.message",null,locale)
    }
}