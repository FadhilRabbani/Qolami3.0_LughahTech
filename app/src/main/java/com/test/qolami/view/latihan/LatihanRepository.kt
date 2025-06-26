package com.test.qolami.view.latihan

import com.test.qolami.model.network.RestfulApi
import com.test.qolami.model.network.RetrofitClient
import com.test.qolami.view.kuis.JawabanRequest
import com.test.qolami.view.kuis.KuisResponse
import com.test.qolami.view.kuis.SubmitJawabanResponse
import com.test.qolami.view.latihan.DataLatihan.SoalAudioResponse
import com.test.qolami.view.latihan.DataLatihan.SoalLatihanResponse
import com.test.qolami.view.latihan.DataLatihan.SoalVideo
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LatihanRepository @Inject constructor(
    private val retrofitClient: RetrofitClient
) {
    suspend fun getSoalLatihanVideo(latihanId: Int): Response<SoalLatihanResponse> {
        return retrofitClient.apiService.getSoalLatihanVideo(latihanId)
    }

    suspend fun getSoalLatihanAudio(latihanId: Int): Response<SoalAudioResponse> {
        return retrofitClient.apiService.getSoalLatihanAudio(latihanId)
    }
    suspend fun getSoalKuis(kategori: String, kuisId: Int): Response<KuisResponse> {
        return retrofitClient.apiService.getSoalKuis(kategori, kuisId)
    }
    suspend fun submitJawabanKuis(jawabanRequest: JawabanRequest): Response<SubmitJawabanResponse> {
        return retrofitClient.apiService.submitJawabanKuis(jawabanRequest)
    }


}

