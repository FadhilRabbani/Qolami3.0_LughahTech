package com.test.qolami.model.data.user


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("profileName")
    val profileName: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("__v")
    val v: Int
)