package com.test.qolami.model.data.user


import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val `data`: DataXX,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)