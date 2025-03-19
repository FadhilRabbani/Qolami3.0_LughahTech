package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class DataLatihanKasrahAudio(
    @SerializedName("latihanKasrahAudio")
    val latihanKasrahAudio: List<LatihanKasrahAudio>
)