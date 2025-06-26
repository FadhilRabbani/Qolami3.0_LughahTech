package com.test.qolami.view.kuis

import com.test.qolami.model.network.RestfulApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class KuisRepository @Inject constructor(
    @Named("authenticated") private val api: RestfulApi.ApiService
) {
    suspend fun getListKuis(): Response<KuisListResponse> {
        return api.getListKuis()
    }
}
