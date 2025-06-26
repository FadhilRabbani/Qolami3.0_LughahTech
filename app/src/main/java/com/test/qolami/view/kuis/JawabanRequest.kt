package com.test.qolami.view.kuis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class JawabanRequest(
    val user_id: Int,
    val kuis_id: Int,
    val jawaban: List<JawabanItem>
) {
    @Parcelize
    data class JawabanItem(
        val soal_id: Int,
        val jenis: String,
        val jawaban_user: String
    ): Parcelable
}
