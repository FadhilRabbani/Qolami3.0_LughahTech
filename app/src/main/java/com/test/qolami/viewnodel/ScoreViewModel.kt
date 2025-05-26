package com.test.qolami.viewnodel


import android.util.Log
import androidx.lifecycle.ViewModel
import com.test.qolami.model.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    private val api: RestfulApi.ApiService
) : ViewModel() {

    // Placeholder kosong, atau bisa kamu tambahkan fungsi baru yang memang valid di BE
    // Contoh fungsi tambahan: mengambil ulang soal latihan
    suspend fun reloadSoalLatihan(id: Int, jenis: String = "video") {
        try {
            val response = api.getSoalLatihan(id, jenis)
            if (response.isSuccessful) {
                Log.d("ScoreViewModel", "Berhasil ambil soal: ${response.body()}")
            } else {
                Log.e("ScoreViewModel", "Gagal ambil soal: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.e("ScoreViewModel", "Exception: ${e.message}")
        }
    }
}
