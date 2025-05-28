package com.test.qolami.view.latihan.DataLatihan

import com.test.qolami.model.network.RestfulApi
import com.test.qolami.model.network.RetrofitClient
import okhttp3.Response

data class SoalLatihanResponse(
    val latihan: LatihanData,
    val soal: List<SoalVideo>
)
data class LatihanData(
    val id: Int,
    val nama: String,
    val kategori_id: Int,
    val kategori_nama: String,
    val gambar_url: String
)