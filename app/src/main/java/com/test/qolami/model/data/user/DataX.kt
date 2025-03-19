package com.test.qolami.model.data.user


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("profileName")
    val username:String,
    @SerializedName("token")
    val token: String
)