package com.test.qolami.model.data.user


import com.google.gson.annotations.SerializedName

data class NewUser(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)