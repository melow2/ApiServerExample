package com.khs.example.user

import java.util.*
import javax.validation.constraints.NotEmpty


data class User(
    var id: Int?,
    @field:NotEmpty
    val name: String,
    val joinDate: Date
)