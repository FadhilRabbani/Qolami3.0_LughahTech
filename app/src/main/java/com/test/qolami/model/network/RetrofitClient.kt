package com.test.qolami.model.network


import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.test.qolami.BuildConfig
import com.test.qolami.MyApp
import javax.inject.Inject

@Singleton
class RetrofitClient @Inject constructor(
    private val retrofit: Retrofit
) {
    val apiService: RestfulApi.ApiService = retrofit.create(RestfulApi.ApiService::class.java)
}
