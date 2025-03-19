package com.test.qolami.model.data.score


import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("scoreDhammah")
    val scoreDhammah: ScoreDhammah,
    @SerializedName("scoreFathah")
    val scoreFathah: ScoreFathah,
    @SerializedName("scoreHijaiyah")
    val scoreHijaiyah: ScoreHijaiyah,
    @SerializedName("scoreKasrah")
    val scoreKasrah: ScoreKasrah,
    @SerializedName("userId")
    val userId: UserId,
    @SerializedName("__v")
    val v: Int
)