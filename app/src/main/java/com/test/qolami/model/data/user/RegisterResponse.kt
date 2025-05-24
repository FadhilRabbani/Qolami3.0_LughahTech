package com.test.qolami.model.data.user

import android.service.autofill.UserData

data class RegisterResponse(
    val message: String,
    val user: UserData,
    val token: String
)

