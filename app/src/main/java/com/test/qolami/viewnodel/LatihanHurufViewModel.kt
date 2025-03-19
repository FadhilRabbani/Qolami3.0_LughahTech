package com.test.qolami.viewnodel


import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.qolami.R

import com.test.qolami.model.data.latihan.*
import com.test.qolami.model.network.RestfulApi
import com.test.qolami.view.latihan.DataLatihanHuruf
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LatihanHurufViewModel @Inject constructor(private val Client: RestfulApi) : ViewModel() {
    val listData = arrayListOf(
        DataLatihanHuruf(R.drawable.img_hijaiyah, "Latihan","Huruf Hijaiyah"),
        DataLatihanHuruf(R.drawable.img_fathah, "Latihan","Huruf Berharakat Fathah"),
        DataLatihanHuruf(R.drawable.img_kasroh, "Latihan","Huruf Berharakat Kasrah"),
        DataLatihanHuruf(R.drawable.img_dhammah, "Latihan","Huruf Berharakat Dhammah"),
        /*DataPelajaranHuruf(R.drawable.img_fathahtain, "Pelajaran 5","Huruf Berharakat Fathahtain"),
        DataPelajaranHuruf(R.drawable.img_kasrahtain, "Pelajaran 6","Huruf Berharakat Kasrahtain"),
        DataPelajaranHuruf(R.drawable.dhammahtain, "Pelajaran 7","Huruf Berharakat Dhammahtain"),
        DataPelajaranHuruf(R.drawable.img_sukun, "Pelajaran 8","Huruf Berharakat Sukun"),
        DataPelajaranHuruf(R.drawable.img_tasyjid, "Pelajaran 9","Huruf Berharakat Tasydid")*/
    )
    val getDataHuruf : MutableLiveData<List<DataLatihanHuruf>> = MutableLiveData()
    fun getData(){
        getDataHuruf.value = listData
    }

    private var liveDataSoalImage: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
    val dataSoalImage: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImage
    fun getSoal() {
        Client.getSoalImage().enqueue(object : Callback<BankSoalImageResponse> {
            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalImage.postValue(response.body()!!.data)

                } else {
                    liveDataSoalImage.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalImageFathah: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
    val dataSoalImageFathah: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImageFathah
    fun getSoalFathah() {
        Client.getSoalImageFathah().enqueue(object : Callback<BankSoalImageResponse> {
            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalImageFathah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalImageFathah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalImageKasrah: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
    val dataSoalImageKasrah: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImageKasrah
    fun getSoalKasrah() {
        Client.getSoalImageKasrah().enqueue(object : Callback<BankSoalImageResponse> {
            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalImageKasrah.postValue(response.body()!!.data)


                } else {
                    liveDataSoalImageKasrah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalImageDhammah: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
    val dataSoalImageDhammah: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImageDhammah
    fun getSoalDhammah() {
        Client.getSoalImageDhammah().enqueue(object : Callback<BankSoalImageResponse> {
            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalImageDhammah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalImageDhammah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalVideosHijaiyah: MutableLiveData<DataLatihanHijaiyahVideo> = MutableLiveData()
    val dataSoalVideosHijaiyah: LiveData<DataLatihanHijaiyahVideo> get() = liveDataSoalVideosHijaiyah
    fun getSoalVideoHijaiyah() {
        Client.getSoalVideosHijaiyah().enqueue(object : Callback<DataSoalHijaiyah> {
            override fun onResponse(call: Call<DataSoalHijaiyah>, response: Response<DataSoalHijaiyah>) {
                if (response.isSuccessful) {
                    liveDataSoalVideosHijaiyah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalVideosHijaiyah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<DataSoalHijaiyah>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalVideosFathah: MutableLiveData<DataLatihanFathahVideos> = MutableLiveData()
    val dataSoalVideosFathah: LiveData<DataLatihanFathahVideos> get() = liveDataSoalVideosFathah
    fun getSoalVideoFathah() {
        Client.getSoalVideosFathah().enqueue(object : Callback<BankSoalVideoResponse> {
            override fun onResponse(call: Call<BankSoalVideoResponse>, response: Response<BankSoalVideoResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalVideosFathah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalVideosFathah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalVideoResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalVideosKasrah: MutableLiveData<DataLatihanKasrahVideo> = MutableLiveData()
    val dataSoalVideosKasrah: LiveData<DataLatihanKasrahVideo> get() = liveDataSoalVideosKasrah
    fun getSoalVideoKasrah() {
        Client.getSoalVideosKasrah().enqueue(object : Callback<DataSoalKasrah> {
            override fun onResponse(call: Call<DataSoalKasrah>, response: Response<DataSoalKasrah>) {
                if (response.isSuccessful) {
                    liveDataSoalVideosKasrah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalVideosKasrah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<DataSoalKasrah>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalVideosDhammah: MutableLiveData<DataLatihanDhammahVideo> = MutableLiveData()
    val dataSoalVideosDhammah: LiveData<DataLatihanDhammahVideo> get() = liveDataSoalVideosDhammah
    fun getSoalVideoDhammah() {
        Client.getSoalVideosDhammah().enqueue(object : Callback<DataSoalDhammah> {
            override fun onResponse(call: Call<DataSoalDhammah>, response: Response<DataSoalDhammah>) {
                if (response.isSuccessful) {
                    liveDataSoalVideosDhammah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalVideosDhammah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<DataSoalDhammah>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalAudioHijaiyah: MutableLiveData<DataLatihanHijaiyahAudio> = MutableLiveData()
    val dataSoalAudioHijaiyah: LiveData<DataLatihanHijaiyahAudio> get() = liveDataSoalAudioHijaiyah
    fun getSoalAudiHijaiyah() {
        Client.getSoalAudioHijaiyah().enqueue(object : Callback<BankSoalAudioResponse> {
            override fun onResponse(call: Call<BankSoalAudioResponse>, response: Response<BankSoalAudioResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalAudioHijaiyah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalAudioHijaiyah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalAudioResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalAudioFathah: MutableLiveData<DataLatihanFathahAudio> = MutableLiveData()
    val dataSoalAudioFathah: LiveData<DataLatihanFathahAudio> get() = liveDataSoalAudioFathah
    fun getSoalAudioFathah() {
        Client.getSoalAudioFathah().enqueue(object : Callback<BankSoalAudioFathahResponse> {
            override fun onResponse(call: Call<BankSoalAudioFathahResponse>, response: Response<BankSoalAudioFathahResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalAudioFathah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalAudioFathah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalAudioFathahResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalAudioKasrah: MutableLiveData<DataLatihanKasrahAudio> = MutableLiveData()
    val dataSoalAudioKasrah: LiveData<DataLatihanKasrahAudio> get() = liveDataSoalAudioKasrah
    fun getSoalAudioKasrah() {
        Client.getSoalAudioKasrah().enqueue(object : Callback<BankSoalAudioKasrahResponse> {
            override fun onResponse(call: Call<BankSoalAudioKasrahResponse>, response: Response<BankSoalAudioKasrahResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalAudioKasrah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalAudioKasrah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalAudioKasrahResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
    private var liveDataSoalAudioDhammah: MutableLiveData<DataLatihanDhammahAudio> = MutableLiveData()
    val dataSoalAudioDhammah: LiveData<DataLatihanDhammahAudio> get() = liveDataSoalAudioDhammah
    fun getSoalAudioDhammah() {
        Client.getSoalAudioDhammah().enqueue(object : Callback<BankSoalAudioDhammahResponse> {
            override fun onResponse(call: Call<BankSoalAudioDhammahResponse>, response: Response<BankSoalAudioDhammahResponse>) {
                if (response.isSuccessful) {
                    liveDataSoalAudioDhammah.postValue(response.body()!!.data)

                } else {
                    liveDataSoalAudioDhammah.postValue(null)
                    Log.e("Error", "onFailure: Error")
                }
            }

            override fun onFailure(call: Call<BankSoalAudioDhammahResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
}
