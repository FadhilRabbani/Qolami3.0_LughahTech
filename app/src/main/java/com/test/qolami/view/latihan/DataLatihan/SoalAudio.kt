package com.test.qolami.view.latihan.DataLatihan

data class SoalAudio(
    val id: Int,
    val latihan_id: Int,
    val latihan_nama: String,
    val kategori_nama: String,
    val media_url: String,
    val opsi_a: String,
    val opsi_b: String,
    val opsi_c: String,
    val opsi_d: String,
    val jawaban: String
)
