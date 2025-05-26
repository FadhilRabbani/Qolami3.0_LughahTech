package com.test.qolami.model.network

import com.test.qolami.model.data.latihan.*
import com.test.qolami.model.data.score.*
import com.test.qolami.model.data.score.DataX
import com.test.qolami.model.data.user.*
import com.test.qolami.model.data.user.Data
import com.test.qolami.view.latihan.DataLatihan.SoalLatihanResponse
import com.test.qolami.view.latihan.DataLatihan.SoalVideo
import com.test.qolami.view.latihan.LatihanListResponse
import com.test.qolami.view.pelajaran.data.IsiPelajaran
import com.test.qolami.view.pelajaran.data.PelajaranResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RestfulApi {
    interface ApiService {
        @POST("register")
        suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>

        @POST("login")
        suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

        @GET("pelajaran/{pelajaran_id}/{id}")
        fun getPelajaran(
            @Path("pelajaran_id") pelajaranId: Int,
            @Path("id") id: Int
        ): Call<PelajaranResponse>

        @GET("latihan")
        fun getListLatihan(): Call<LatihanListResponse>

        @GET("latihan/{latihanId}/{jenis}")
        suspend fun getSoalLatihan(
            @Path("latihanId") latihanId: Int,
            @Path("jenis") jenis: String = "video"
        ): Response<SoalLatihanResponse>
    }
}