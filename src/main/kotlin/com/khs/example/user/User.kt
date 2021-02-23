package com.khs.example.user

import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.validation.constraints.NotEmpty


// @JsonIgnoreProperties(value = arrayOf("password"))
@JsonFilter("User")
data class User(
    var id: Int?,
    val password: String,
    @field:NotEmpty(message = "name이 비었습니다.")
    val name: String,
    val joinDate: Date,
)