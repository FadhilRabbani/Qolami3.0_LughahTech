package com.test.qolami.model.data.user

data class LoginResponse(
    val message: String,
    val user: UserData,
    val token: String
)
