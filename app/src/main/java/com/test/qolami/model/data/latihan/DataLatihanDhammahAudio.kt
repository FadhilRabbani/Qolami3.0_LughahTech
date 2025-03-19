package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class DataLatihanDhammahAudio(
    @SerializedName("latihanDhammahAudio")
    val latihanDhammahAudio: List<LatihanDhammahAudio>
)