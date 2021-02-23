package com.khs.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*

@SpringBootApplication
class ExampleApplication

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}

@Bean
fun localResolver(): SessionLocaleResolver {
    val resolver = SessionLocaleResolver()
    resolver.setDefaultLocale(Locale.KOREA)
    return resolver
}
