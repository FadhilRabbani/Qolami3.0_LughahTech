package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class DataSoalKasrah(
    @SerializedName("data")
    val `data`: DataLatihanKasrahVideo,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)