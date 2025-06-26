package com.test.qolami.view.kuis

data class KuisResponse(
    val kuis: KuisInfo,
    val soal: List<SoalKuis>
)

data class KuisInfo(
    val id: Int,
    val nama: String,
    val kategori: String
)

