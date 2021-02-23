package com.khs.example.user.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
data class UserNotFoundException(
        override val message: String? = null
) : RuntimeException()