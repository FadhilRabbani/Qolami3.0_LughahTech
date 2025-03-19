package com.test.qolami.model.data.latihan


import com.google.gson.annotations.SerializedName

data class DataLatihanHijaiyah(
    @SerializedName("latihanHijaiyah")
    val latihanHijaiyah: List<LatihanHijaiyah>
)