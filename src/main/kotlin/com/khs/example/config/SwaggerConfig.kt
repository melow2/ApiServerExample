package com.khs.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    // http://localhost:8088/actuator/health
    // http://localhost:8088/swagger-ui.html
    private val DEFAULT_CONTACT = Contact("KwonHyeokSin", "http://www.joneconsulting.co.kr", "melow2@naver.com")
    private val DEFAULT_API_INFO = ApiInfo(
        "Awesome API Title",
        "My User management REST API Service",
        "1.0",
        "urn:tos",
        DEFAULT_CONTACT,
        "Apache 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        ArrayList()
    )

    private val DEFAULT_PRODUCES_AND_CONSUMES:Set<String> = hashSetOf("application/json","application/xml")

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_PRODUCES_AND_CONSUMES)
            .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
    }
}