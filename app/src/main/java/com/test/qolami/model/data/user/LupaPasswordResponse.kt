package com.test.qolami.model.data.user


import com.google.gson.annotations.SerializedName

data class LupaPasswordResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)