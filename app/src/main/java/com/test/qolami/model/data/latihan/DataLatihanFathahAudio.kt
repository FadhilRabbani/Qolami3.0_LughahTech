package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class DataLatihanFathahAudio(
    @SerializedName("latihanFathahAudio")
    val latihanFathahAudio: List<LatihanFathahAudio>
)