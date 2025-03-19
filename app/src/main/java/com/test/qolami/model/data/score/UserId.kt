package com.test.qolami.model.data.score


import com.google.gson.annotations.SerializedName

data class UserId(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("username")
    val username: String
)