package com.test.qolami.view.user

data class EmailRequest(
    val email: String
)

data class OtpResponse(
    val message: String
)

data class ResetPasswordRequest(
    val email: String,
    val otp_code: String,
    val new_password: String,
    val new_password_confirmation: String
)

data class BasicResponse(
    val message: String,
    val error: String? = null
)

