package com.test.qolami.viewnodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.qolami.model.data.score.*
import com.test.qolami.model.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel@Inject constructor(private val Client: RestfulApi) : ViewModel() {
    private var liveDataScoreHijaiyahImage: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreHijaiyahImage(userId: String, score: Int) {
        Client.patchScoreHijaiyahImage(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreHijaiyahImage.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreHijaiyahImage.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreHijaiyahVideo: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreHijaiyahVideo(userId: String, score: Int) {
        Client.patchScoreHijaiyahVideo(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreHijaiyahVideo.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreHijaiyahVideo.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreHijaiyahAudio: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreHijaiyahAudio(userId: String, score: Int) {
        Client.patchScoreHijaiyahAudio(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreHijaiyahAudio.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreHijaiyahAudio.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreFathahImage: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreFathahImage(userId: String, score: Int) {
        Client.patchScoreFathahImage(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreFathahImage.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreFathahImage.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreFathahVideo: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreFathahVideo(userId: String, score: Int) {
        Client.patchScoreFathahVideo(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreFathahVideo.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreFathahVideo.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreFathahAudio: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreFathahAudio(userId: String, score: Int) {
        Client.patchScoreFathahAudio(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreFathahAudio.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreFathahAudio.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreKasrahAudio: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreKasrahAudio(userId: String, score: Int) {
        Client.patchScoreKasrahAudio(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreKasrahAudio.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreKasrahAudio.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreKasrahImage: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreKasrahImage(userId: String, score: Int) {
        Client.patchScoreKasrahImage(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreKasrahImage.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreKasrahImage.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreKasrahVideo: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreKasrahVideo(userId: String, score: Int) {
        Client.patchScoreKasrahVideo(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreKasrahVideo.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreKasrahVideo.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreDhammahAudio: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreDhammahAudio(userId: String, score: Int) {
        Client.patchScoreDhammahAudio(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreDhammahAudio.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreDhammahAudio.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreDhammahImage: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreDhammahImage(userId: String, score: Int) {
        Client.patchScoreDhammahImage(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreDhammahImage.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreDhammahImage.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataScoreDhammahVideo: MutableLiveData<ScoreX> = MutableLiveData()
    fun patchScoreDhammahVideo(userId: String, score: Int) {
        Client.patchScoreDhammahVideo(userId, score).enqueue(object : Callback<PatchScoreResponse> {
            override fun onResponse(call: Call<PatchScoreResponse>, response: Response<PatchScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataScoreDhammahVideo.postValue(response.body()!!.data.score)

                } else {
                    liveDataScoreDhammahVideo.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<PatchScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }


    private var liveDataGetScore : MutableLiveData<ScoreHijaiyah> = MutableLiveData()
    val dataGetScore : LiveData<ScoreHijaiyah>get() = liveDataGetScore
    fun getScoreHijaiyah(userId: String) {
        Client.getScore(userId).enqueue(object : Callback<GetScoreResponse> {
            override fun onResponse(call: Call<GetScoreResponse>, response: Response<GetScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataGetScore.postValue(response.body()!!.data.score.scoreHijaiyah)

                } else {
                    liveDataGetScore.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<GetScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataGetScoreFathah : MutableLiveData<ScoreFathah> = MutableLiveData()
    val dataGetScoreFathah : LiveData<ScoreFathah>get() = liveDataGetScoreFathah
    fun getScoreFathah(userId: String) {
        Client.getScore(userId).enqueue(object : Callback<GetScoreResponse> {
            override fun onResponse(call: Call<GetScoreResponse>, response: Response<GetScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataGetScoreFathah.postValue(response.body()!!.data.score.scoreFathah)

                } else {
                    liveDataGetScoreFathah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<GetScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataGetScoreKasrah : MutableLiveData<ScoreKasrah> = MutableLiveData()
    val dataGetScoreKasrah : LiveData<ScoreKasrah>get() = liveDataGetScoreKasrah
    fun getScoreKasrah(userId: String) {
        Client.getScore(userId).enqueue(object : Callback<GetScoreResponse> {
            override fun onResponse(call: Call<GetScoreResponse>, response: Response<GetScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataGetScoreKasrah.postValue(response.body()!!.data.score.scoreKasrah)

                } else {
                    liveDataGetScoreKasrah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<GetScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataGetScoreDhammah : MutableLiveData<ScoreDhammah> = MutableLiveData()
    val dataGetScoreDhammah : LiveData<ScoreDhammah>get() = liveDataGetScoreDhammah
    fun getScoreDhammah(userId: String) {
        Client.getScore(userId).enqueue(object : Callback<GetScoreResponse> {
            override fun onResponse(call: Call<GetScoreResponse>, response: Response<GetScoreResponse>) {
                if (response.isSuccessful) {
                    liveDataGetScoreDhammah.postValue(response.body()!!.data.score.scoreDhammah)

                } else {
                    liveDataGetScoreDhammah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }
            override fun onFailure(call: Call<GetScoreResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }

}