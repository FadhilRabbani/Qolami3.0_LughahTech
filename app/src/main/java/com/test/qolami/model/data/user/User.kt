package com.test.qolami.model.data.user


import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val name: String,
    val email: String
)
