package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class LatihanFathahAudio(
    @SerializedName("audio")
    val audio: String,
    @SerializedName("correctIndex")
    val correctIndex: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("options")
    val options: List<String>,
    @SerializedName("question")
    val question: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("__v")
    val v: Int
)