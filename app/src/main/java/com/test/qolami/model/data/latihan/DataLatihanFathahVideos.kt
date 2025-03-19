package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class DataLatihanFathahVideos(
    @SerializedName("latihanFathahVideo")
    val latihanFathahVideo: List<LatihanFathahVideo>
)