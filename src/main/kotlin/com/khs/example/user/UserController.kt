package com.khs.example.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    private lateinit var service: UserDaoService

    @GetMapping("/users")
    fun retrieveAllUsers(): List<User> = service.findAll()

}