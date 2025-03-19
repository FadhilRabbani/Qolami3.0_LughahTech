package com.test.qolami.model.data.score


import com.google.gson.annotations.SerializedName

data class GetScoreResponse(
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)