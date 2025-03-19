package com.test.qolami.model.data.score


import com.google.gson.annotations.SerializedName

data class ScoreHijaiyah(
    @SerializedName("scoreAudio")
    val scoreAudio: Int,
    @SerializedName("scoreImage")
    val scoreImage: Int,
    @SerializedName("scoreVideo")
    val scoreVideo: Int
)