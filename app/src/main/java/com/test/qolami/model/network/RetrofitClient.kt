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
//object RetrofitClient {
//    private const val BASE_URL = "http://192.168.1.12:8000/api/"
//
//    private val loggingInterceptor = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    private val client = OkHttpClient.Builder()
//        .addInterceptor { chain ->
//            val requestBuilder = chain.request().newBuilder()
//            val sharedPrefs = MyApp.instance.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
//            val token = sharedPrefs.getString("token", null)
//            if (!token.isNullOrEmpty()) {
//                requestBuilder.addHeader("Authorization", "Bearer $token")
//            }
//            chain.proceed(requestBuilder.build())
//        }
//        .addInterceptor(loggingInterceptor)
//        .build()
//
//    val instance: RestfulApi.ApiService by lazy {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        retrofit.create(RestfulApi.ApiService::class.java)


//    private const val  BASE_URL = BuildConfig.BASE_URL
//
//    private val logging : HttpLoggingInterceptor
//        get() {
//            val httpLoggingInterceptor = HttpLoggingInterceptor()
//            return httpLoggingInterceptor.apply {
//                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//            }
//        }
//
//
//    private val client = OkHttpClient.Builder().addInterceptor(logging).build()
//    @Singleton
//    @Provides
//    fun provideRetrofit() : Retrofit =
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//
//    @Singleton
//    @Provides
//    fun provideFilmApi(retrofit: Retrofit): RestfulApi =
//        retrofit.create(RestfulApi::class.java)
//}}