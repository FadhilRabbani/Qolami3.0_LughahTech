package com.test.qolami.view.kuis

data class SubmitJawabanResponse(
    val message: String,
    val data: JawabanData
)

data class JawabanData(
    val jumlah_benar: Int,
    val bintang: Int
)
