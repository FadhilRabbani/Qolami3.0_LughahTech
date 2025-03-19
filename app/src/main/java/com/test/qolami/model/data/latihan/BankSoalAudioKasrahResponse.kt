package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class BankSoalAudioKasrahResponse(
    @SerializedName("data")
    val `data`: DataLatihanKasrahAudio,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)