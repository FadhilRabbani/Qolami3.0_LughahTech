package com.test.qolami.model.data.score


import com.google.gson.annotations.SerializedName

data class PatchScoreResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)