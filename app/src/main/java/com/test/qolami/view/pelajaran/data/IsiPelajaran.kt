package com.test.qolami.view.pelajaran.data

import com.google.gson.annotations.SerializedName

data class IsiPelajaran(
    val id: Int,
    val pelajaran_id: Int,
    val huruf_kata_rangkaian: String,
    val keterangan: String,
    @SerializedName("video_url")
    val videoUrl: String?,

    @SerializedName("gambar_url")
    val gambarUrl: String?
)
