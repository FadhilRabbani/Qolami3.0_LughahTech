package com.test.qolami.model.network

import com.test.qolami.model.data.latihan.*
import com.test.qolami.model.data.score.*
import com.test.qolami.model.data.score.DataX
import com.test.qolami.model.data.user.*
import com.test.qolami.model.data.user.Data
import com.test.qolami.view.account.data.UpdateNameRequest
import com.test.qolami.view.account.data.UpdateNameResponse
import com.test.qolami.view.kuis.JawabanRequest
import com.test.qolami.view.kuis.KuisItem
import com.test.qolami.view.kuis.KuisListResponse
import com.test.qolami.view.kuis.KuisResponse
import com.test.qolami.view.kuis.SubmitJawabanResponse
import com.test.qolami.view.latihan.DataLatihan.SoalAudioResponse
import com.test.qolami.view.latihan.DataLatihan.SoalLatihanResponse
import com.test.qolami.view.latihan.DataLatihan.SoalVideo
import com.test.qolami.view.latihan.LatihanListResponse
import com.test.qolami.view.pelajaran.data.IsiPelajaran
import com.test.qolami.view.pelajaran.data.PelajaranResponse
import com.test.qolami.view.user.BasicResponse
import com.test.qolami.view.user.EmailRequest
import com.test.qolami.view.user.OtpResponse
import com.test.qolami.view.user.ResetPasswordRequest
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

        @GET("latihan/{latihanId}/video")
        suspend fun getSoalLatihanVideo(
            @Path("latihanId") latihanId: Int
        ): Response<SoalLatihanResponse>
        @GET("latihan/{latihanId}/audio")
        suspend fun getSoalLatihanAudio(
            @Path("latihanId") latihanId: Int
        ): Response<SoalAudioResponse>
        @GET("list-kuis")
        suspend fun getListKuis(): Response<KuisListResponse>

        @GET("kuis/{kategori}/{kuisId}")
        suspend fun getSoalKuis(
            @Path("kategori") kategori: String,
            @Path("kuisId") kuisId: Int
        ): Response<KuisResponse>
        @POST("kuis/submit")
        suspend fun submitJawabanKuis(
            @Body request: JawabanRequest
        ): Response<SubmitJawabanResponse>
        @POST("send-otp")
        suspend fun sendOtp(@Body email: EmailRequest): Response<OtpResponse>
        @POST("change-password")
        suspend fun changePassword(@Body request: ResetPasswordRequest): Response<BasicResponse>
        @POST("rename-account")  // Ganti menjadi POST sesuai API route
        suspend fun updateUserName(
            @Body updateNameRequest: UpdateNameRequest
        ): Response<UpdateNameResponse>







    }
}