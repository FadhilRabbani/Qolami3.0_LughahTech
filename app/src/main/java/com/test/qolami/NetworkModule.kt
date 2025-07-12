package com.test.qolami

import android.content.Context
import android.content.SharedPreferences
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
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://103.174.114.82/api/"

    @Provides
    @Singleton
    fun provideLoginSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(@ApplicationContext context: Context): AuthInterceptor {
        return AuthInterceptor(context)
    }

    @Provides
    @Singleton
    @Named("unauthenticated") // 👉 Retrofit TANPA token (login/register)
    fun provideUnauthenticatedRetrofit(): Retrofit {
        val client = OkHttpClient.Builder().build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    @Provides
    @Singleton
    @Named("unauthenticated_client")
    fun provideUnauthenticatedRetrofitClient(
        @Named("unauthenticated") retrofit: Retrofit
    ): RetrofitClient {
        return RetrofitClient(retrofit)
    }

    @Provides
    @Singleton
    @Named("authenticated") // 👉 Retrofit DENGAN token
    fun provideAuthenticatedRetrofit(authInterceptor: AuthInterceptor): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    @Named("unauthenticated")
    fun provideUnauthenticatedApiService(@Named("unauthenticated") retrofit: Retrofit): RestfulApi.ApiService {
        return retrofit.create(RestfulApi.ApiService::class.java)
    }

    @Provides
    @Singleton
    @Named("authenticated")
    fun provideAuthenticatedApiService(@Named("authenticated") retrofit: Retrofit): RestfulApi.ApiService {
        return retrofit.create(RestfulApi.ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(@Named("authenticated") retrofit: Retrofit): RetrofitClient {
        return RetrofitClient(retrofit)
    }
    @Provides
    @Singleton
    @Named("authenticated_client")
    fun provideAuthenticatedRetrofitClient(
        @Named("authenticated") retrofit: Retrofit
    ): RetrofitClient {
        return RetrofitClient(retrofit)
    }

}
