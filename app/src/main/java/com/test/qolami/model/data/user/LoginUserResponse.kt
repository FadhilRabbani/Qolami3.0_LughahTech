package com.test.qolami.model.data.user


import com.google.gson.annotations.SerializedName

data class LoginUserResponse(
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)