package com.test.qolami.view.kuis

data class SoalKuis(
    val id: Int,
    val jenis: String,
    val file_url: String,
    val opsi: Map<String, String>,
    val jawaban: String
)

