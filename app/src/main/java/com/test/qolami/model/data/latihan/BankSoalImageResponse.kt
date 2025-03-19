package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class BankSoalImageResponse(
    @SerializedName("data")
    val `data`: DataLatihanHijaiyah,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)