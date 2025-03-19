package com.test.qolami.model.network

import com.test.qolami.model.data.latihan.*
import com.test.qolami.model.data.score.*
import com.test.qolami.model.data.score.DataX
import com.test.qolami.model.data.user.*
import com.test.qolami.model.data.user.Data
import retrofit2.Call
import retrofit2.http.*

interface RestfulApi {
    @POST("auth/register")
    fun postRegister(@Body request: Data): Call<NewUser>

    @FormUrlEncoded
    @POST("auth/login")
    fun postLogin(
        @Field("username") username: String,
        @Field("password") password: String): Call<LoginUserResponse>

    @FormUrlEncoded
    @PUT("auth/forgot-password")
    fun putLupaPassword(
        @Field("username") username: String,
        @Field("newPassword") newPassword:String,
        @Field("repeatNewPassword") repeatNewPassword:String
    ): Call<LupaPasswordResponse>
    @FormUrlEncoded
    @PUT("user/reset-password/{id}")
    fun putGantiPassword(
        @Path("id") id:String,
        @Field("newPassword") newPassword: String,
        @Field("repeatNewPassword")repeatNewPassword: String
    ):Call<GantiPasswordResponse>
    @FormUrlEncoded
    @PATCH("user/profile-name/{userId}")
    fun patchUser(
        @Path("userId") userId: String,
        @Field("profileName") profileName:String
    ):Call<GantiProfileNameResponse>
    @GET("images-practice/hijaiyah")
    fun getSoalImage(): Call<BankSoalImageResponse>
    @GET("images-practice/fathah")
    fun getSoalImageFathah(): Call<BankSoalImageResponse>
    @GET("images-practice/kasrah")
    fun getSoalImageKasrah(): Call<BankSoalImageResponse>
    @GET("images-practice/dhammah")
    fun getSoalImageDhammah(): Call<BankSoalImageResponse>
    @GET("videos-practice/hijaiyah")
    fun getSoalVideosHijaiyah(): Call<DataSoalHijaiyah>
    @GET("videos-practice/fathah")
    fun getSoalVideosFathah(): Call<BankSoalVideoResponse>
    @GET("videos-practice/kasrah")
    fun getSoalVideosKasrah(): Call<DataSoalKasrah>
    @GET("videos-practice/dhammah")
    fun getSoalVideosDhammah(): Call<DataSoalDhammah>
    @GET("audios-practice/hijaiyah")
    fun getSoalAudioHijaiyah(): Call<BankSoalAudioResponse>
    @GET("audios-practice/fathah")
    fun getSoalAudioFathah():Call<BankSoalAudioFathahResponse>
    @GET("audios-practice/kasrah")
    fun getSoalAudioKasrah():Call<BankSoalAudioKasrahResponse>
    @GET("audios-practice/dhammah")
    fun getSoalAudioDhammah():Call<BankSoalAudioDhammahResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreHijaiyahImage(
        @Path ("userId") userId: String,
        @Field("scoreHijaiyahImage") scoreHijaiyahImage:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreHijaiyahVideo(
        @Path ("userId") userId: String,
        @Field("scoreHijaiyahVideo") scoreHijaiyahVideo:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreFathahImage(
        @Path ("userId") userId: String,
        @Field("scoreFathahImage") scoreHijaiyahImage:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreFathahVideo(
        @Path ("userId") userId: String,
        @Field("scoreFathahVideo") scoreFathahVideo:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreFathahAudio(
        @Path ("userId") userId: String,
        @Field("scoreFathahAudio") scoreFathahAudio:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreHijaiyahAudio(
        @Path ("userId") userId: String,
        @Field("scoreHijaiyahAudio") scoreHijaiyahAudio:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreKasrahAudio(
        @Path ("userId") userId: String,
        @Field("scoreKasrahAudio") scoreKasrahAudio:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreKasrahVideo(
        @Path ("userId") userId: String,
        @Field("scoreKasrahVideo") scoreKasrahVideo:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreKasrahImage(
        @Path ("userId") userId: String,
        @Field("scoreKasrahImage") scoreKasrahImage:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreDhammahImage(
        @Path ("userId") userId: String,
        @Field("scoreDhammahImage") scoreDhammahImage:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreDhammahAudio(
        @Path ("userId") userId: String,
        @Field("scoreDhammahAudio") scoreDhammahAudio:Int
    ):Call<PatchScoreResponse>
    @FormUrlEncoded
    @PATCH("user/score/{userId}")
    fun patchScoreDhammahVideo(
        @Path ("userId") userId: String,
        @Field("scoreDhammahVideo") scoreDhammahVideo:Int
    ):Call<PatchScoreResponse>
    @GET("user/score/{userId}")
    fun getScore(
        @Path ("userId") userId: String
    ):Call<GetScoreResponse>
}