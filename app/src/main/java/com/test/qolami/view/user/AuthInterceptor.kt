package com.test.qolami.view.user

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(@ApplicationContext private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val prefs = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val token = prefs.getString("token", null)

        Log.d("AuthInterceptor", "Token dari SharedPreferences: $token")
        Log.d("AuthInterceptor", "Request URL: ${chain.request().url}")

        val requestBuilder = chain.request().newBuilder()
        if (!token.isNullOrEmpty()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }
        requestBuilder.addHeader("Accept", "application/json")

        return chain.proceed(requestBuilder.build())
    }
}