package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class BankSoalAudioFathahResponse(
    @SerializedName("data")
    val `data`: DataLatihanFathahAudio,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)