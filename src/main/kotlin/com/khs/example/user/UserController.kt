package com.khs.example.user

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import com.khs.example.user.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    private lateinit var service: UserDaoService

    @GetMapping("/users")
    fun retrieveAllUsers(): MappingJacksonValue {
        val users =  service.findAll()
        val filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","joinDate")
        val filters = SimpleFilterProvider().addFilter("User",filter)
        val mapping = MappingJacksonValue(users)
        mapping.filters = filters
        return mapping
    }

    @PostMapping("/users")
    fun createUser(@RequestBody @Validated user: User) {
        val savedUser = service.save(user)
    }

    @GetMapping("/users/{id}")
    fun retrieveUser(@PathVariable id: Int): User? {
        val findUser = service.findOne(id)
        if (findUser == null) throw UserNotFoundException(String.format("ID[%s] not found", id))
        else return findUser
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id:Int): User? {
        val findUser = service.delete(id)
        if (findUser == null) throw Exception(String.format("ID[%s] not found", id))
        else return findUser
    }

}