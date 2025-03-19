package com.test.qolami.model.data.score


import com.google.gson.annotations.SerializedName

data class ScoreX(
    @SerializedName("scoreDhammahAudio")
    val scoreDhammahAudio: Any,
    @SerializedName("scoreDhammahImage")
    val scoreDhammahImage: Any,
    @SerializedName("scoreDhammahVideo")
    val scoreDhammahVideo: Any,
    @SerializedName("scoreFathahAudio")
    val scoreFathahAudio: Any,
    @SerializedName("scoreFathahImage")
    val scoreFathahImage: Any,
    @SerializedName("scoreFathahVideo")
    val scoreFathahVideo: Any,
    @SerializedName("scoreHijaiyahAudio")
    val scoreHijaiyahAudio: Any,
    @SerializedName("scoreHijaiyahImage")
    val scoreHijaiyahImage: Any,
    @SerializedName("scoreHijaiyahVideo")
    val scoreHijaiyahVideo: Any,
    @SerializedName("scoreKasrahAudio")
    val scoreKasrahAudio: Any,
    @SerializedName("scoreKasrahImage")
    val scoreKasrahImage: Any,
    @SerializedName("scoreKasrahVideo")
    val scoreKasrahVideo: Any,
)