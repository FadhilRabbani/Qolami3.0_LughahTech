package com.test.qolami


import android.content.Context
import com.test.qolami.model.network.RestfulApi
import com.test.qolami.model.network.RetrofitClient
import com.test.qolami.view.user.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthInterceptor(@ApplicationContext context: Context): AuthInterceptor {
        return AuthInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.12:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // <- Interceptor dipasang di sini
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): RestfulApi.ApiService {
        return retrofit.create(RestfulApi.ApiService::class.java)
    }
}

