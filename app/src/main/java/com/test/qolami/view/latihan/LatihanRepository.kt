package com.test.qolami.view.latihan

import com.test.qolami.model.network.RestfulApi
import com.test.qolami.model.network.RetrofitClient
import com.test.qolami.view.latihan.DataLatihan.SoalAudioResponse
import com.test.qolami.view.latihan.DataLatihan.SoalLatihanResponse
import com.test.qolami.view.latihan.DataLatihan.SoalVideo
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LatihanRepository @Inject constructor(
    private val retrofitClient: RetrofitClient  // Mendapatkan RetrofitClient dari Hilt
) {
    suspend fun getSoalLatihanVideo(latihanId: Int): Response<SoalLatihanResponse> {
        return retrofitClient.apiService.getSoalLatihanVideo(latihanId)
    }

    suspend fun getSoalLatihanAudio(latihanId: Int): Response<SoalAudioResponse> {
        return retrofitClient.apiService.getSoalLatihanAudio(latihanId)
    }
}
//    suspend fun getSoalLatihan(latihanId: Int, jenis: String): List<SoalVideo> {
//        // Mengambil response dari API
//        val response = retrofitClient.apiService.getSoalLatihan(latihanId, jenis)
//
//        // Mengecek apakah response berhasil dan mengembalikan body (data) dari response
//        if (response.isSuccessful) {
//            return response.body() ?: emptyList() // Kembalikan data atau list kosong jika body null
//        } else {
//            throw Exception("Error: ${response.code()}")
//        }
//    }

//class LatihanRepository @Inject constructor(private val apiService: RestfulApi.ApiService) {
//
//    suspend fun getSoalVideo(latihanId: Int): List<SoalVideo>? {
//        val response = apiService.getSoalLatihan(latihanId, "video")
//        if (response.isSuccessful) {
//            return response.body()
//        }
//        return null
//    }
//}
