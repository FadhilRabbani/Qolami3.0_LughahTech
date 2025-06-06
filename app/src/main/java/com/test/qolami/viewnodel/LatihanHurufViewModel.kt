package com.test.qolami.viewnodel


import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.qolami.R
import com.test.qolami.view.latihan.DataLatihan.SoalLatihanResponse
import com.test.qolami.model.data.latihan.*
import com.test.qolami.model.network.RestfulApi
import com.test.qolami.view.latihan.DataLatihan.SoalAudio
import com.test.qolami.view.latihan.DataLatihan.SoalVideo
import com.test.qolami.view.latihan.DataLatihanHuruf
import com.test.qolami.view.latihan.LatihanItem
import com.test.qolami.view.latihan.LatihanListResponse
import com.test.qolami.view.latihan.LatihanRepository
import com.test.qolami.view.pelajaran.data.DataPelajaranHuruf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LatihanHurufViewModel @Inject constructor (private val repository: LatihanRepository): ViewModel() {
//    private val Client = com.test.qolami.model.network.RetrofitClient.instance
    val listData = arrayListOf(
        DataLatihanHuruf(1,R.drawable.img_fathah, "Latihan 1","Huruf Berharakat Fathah"),
        DataLatihanHuruf(2,R.drawable.img_kasroh, "Latihan 2","Huruf Berharakat Kasrah"),
        DataLatihanHuruf(3,R.drawable.img_dhammah, "Latihan 3","Huruf Berharakat Dhammah"),
        DataLatihanHuruf(4,R.drawable.img_fathahtain, "Latihan 4","Huruf Berharakat Fathahtain"),
        DataLatihanHuruf(5,R.drawable.img_kasrahtain, "Latihan 5","Huruf Berharakat Kasrahtain"),
        DataLatihanHuruf(6,R.drawable.dhammahtain, "Latihan 6","Huruf Berharakat Dhammahtain"),
        /*DataPelajaranHuruf(R.drawable.img_sukun, "Pelajaran 7","Huruf Berharakat Sukun"),
        DataPelajaranHuruf(R.drawable.img_tasyjid, "Pelajaran 8","Huruf Berharakat Tasydid")*/
    )

    val dataLatihanList: MutableLiveData<List<LatihanItem>> = MutableLiveData()

//    fun getListLatihan() {
//        Client.getListLatihan().enqueue(object : Callback<LatihanListResponse> {
//            override fun onResponse(
//                call: Call<LatihanListResponse>,
//                response: Response<LatihanListResponse>
//            ) {
//                if (response.isSuccessful) {
//                    dataLatihanList.postValue(response.body()?.latihan)
//                } else {
//                    Log.e("Latihan", "Gagal: ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<LatihanListResponse>, t: Throwable) {
//                Log.e("Latihan", "Error: ${t.localizedMessage}")
//            }
//        })
//    }

    val getDataHuruf : MutableLiveData<List<DataLatihanHuruf>> = MutableLiveData()
    fun getData(){
        getDataHuruf.value = listData
    }
    private val _soalVideos = MutableLiveData<List<SoalVideo>>()
    val soalVideos: LiveData<List<SoalVideo>> = _soalVideos

    fun loadSoalVideo(latihanId: Int) {
        viewModelScope.launch {
            try {
                // Mengambil response dari repository
                val response = repository.getSoalLatihanVideo(latihanId)

                if (response.isSuccessful) {
                    // Jika response berhasil, ambil body yang berisi data soal
                    val soalResponse = response.body()
                    val soalList = soalResponse?.soal ?: emptyList()
                    _soalVideos.postValue(soalList)

                } else {
                    // Jika response gagal, log error
                    Log.e("Latihan", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("Latihan", "Error fetching soal latihan: ${e.localizedMessage}")
            }
        }
    }
    private val _soalAudios = MutableLiveData<List<SoalAudio>>()
    val soalAudios: LiveData<List<SoalAudio>> = _soalAudios

    fun loadSoalAudio(latihanId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getSoalLatihanAudio(latihanId)
                if (response.isSuccessful) {
                    _soalAudios.postValue(response.body()?.soal ?: emptyList())
                } else {
                    Log.e("AudioSoal", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("AudioSoal", "Exception: ${e.message}")
            }
        }
    }
//    private var liveDataSoalImage: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
//    val dataSoalImage: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImage
//    fun getSoal() {
//        Client.getSoalImage().enqueue(object : Callback<BankSoalImageResponse> {
//            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalImage.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalImage.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalImageFathah: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
//    val dataSoalImageFathah: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImageFathah
//    fun getSoalFathah() {
//        Client.getSoalImageFathah().enqueue(object : Callback<BankSoalImageResponse> {
//            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalImageFathah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalImageFathah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalImageKasrah: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
//    val dataSoalImageKasrah: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImageKasrah
//    fun getSoalKasrah() {
//        Client.getSoalImageKasrah().enqueue(object : Callback<BankSoalImageResponse> {
//            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalImageKasrah.postValue(response.body()!!.data)
//
//
//                } else {
//                    liveDataSoalImageKasrah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalImageDhammah: MutableLiveData<DataLatihanHijaiyah> = MutableLiveData()
//    val dataSoalImageDhammah: LiveData<DataLatihanHijaiyah> get() = liveDataSoalImageDhammah
//    fun getSoalDhammah() {
//        Client.getSoalImageDhammah().enqueue(object : Callback<BankSoalImageResponse> {
//            override fun onResponse(call: Call<BankSoalImageResponse>, response: Response<BankSoalImageResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalImageDhammah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalImageDhammah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalImageResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalVideosHijaiyah: MutableLiveData<DataLatihanHijaiyahVideo> = MutableLiveData()
//    val dataSoalVideosHijaiyah: LiveData<DataLatihanHijaiyahVideo> get() = liveDataSoalVideosHijaiyah
//    fun getSoalVideoHijaiyah() {
//        Client.getSoalVideosHijaiyah().enqueue(object : Callback<DataSoalHijaiyah> {
//            override fun onResponse(call: Call<DataSoalHijaiyah>, response: Response<DataSoalHijaiyah>) {
//                if (response.isSuccessful) {
//                    liveDataSoalVideosHijaiyah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalVideosHijaiyah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<DataSoalHijaiyah>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalVideosFathah: MutableLiveData<DataLatihanFathahVideos> = MutableLiveData()
//    val dataSoalVideosFathah: LiveData<DataLatihanFathahVideos> get() = liveDataSoalVideosFathah
//    fun getSoalVideoFathah() {
//        Client.getSoalVideosFathah().enqueue(object : Callback<BankSoalVideoResponse> {
//            override fun onResponse(call: Call<BankSoalVideoResponse>, response: Response<BankSoalVideoResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalVideosFathah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalVideosFathah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalVideoResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalVideosKasrah: MutableLiveData<DataLatihanKasrahVideo> = MutableLiveData()
//    val dataSoalVideosKasrah: LiveData<DataLatihanKasrahVideo> get() = liveDataSoalVideosKasrah
//    fun getSoalVideoKasrah() {
//        Client.getSoalVideosKasrah().enqueue(object : Callback<DataSoalKasrah> {
//            override fun onResponse(call: Call<DataSoalKasrah>, response: Response<DataSoalKasrah>) {
//                if (response.isSuccessful) {
//                    liveDataSoalVideosKasrah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalVideosKasrah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<DataSoalKasrah>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalVideosDhammah: MutableLiveData<DataLatihanDhammahVideo> = MutableLiveData()
//    val dataSoalVideosDhammah: LiveData<DataLatihanDhammahVideo> get() = liveDataSoalVideosDhammah
//    fun getSoalVideoDhammah() {
//        Client.getSoalVideosDhammah().enqueue(object : Callback<DataSoalDhammah> {
//            override fun onResponse(call: Call<DataSoalDhammah>, response: Response<DataSoalDhammah>) {
//                if (response.isSuccessful) {
//                    liveDataSoalVideosDhammah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalVideosDhammah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<DataSoalDhammah>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalAudioHijaiyah: MutableLiveData<DataLatihanHijaiyahAudio> = MutableLiveData()
//    val dataSoalAudioHijaiyah: LiveData<DataLatihanHijaiyahAudio> get() = liveDataSoalAudioHijaiyah
//    fun getSoalAudiHijaiyah() {
//        Client.getSoalAudioHijaiyah().enqueue(object : Callback<BankSoalAudioResponse> {
//            override fun onResponse(call: Call<BankSoalAudioResponse>, response: Response<BankSoalAudioResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalAudioHijaiyah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalAudioHijaiyah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalAudioResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalAudioFathah: MutableLiveData<DataLatihanFathahAudio> = MutableLiveData()
//    val dataSoalAudioFathah: LiveData<DataLatihanFathahAudio> get() = liveDataSoalAudioFathah
//    fun getSoalAudioFathah() {
//        Client.getSoalAudioFathah().enqueue(object : Callback<BankSoalAudioFathahResponse> {
//            override fun onResponse(call: Call<BankSoalAudioFathahResponse>, response: Response<BankSoalAudioFathahResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalAudioFathah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalAudioFathah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalAudioFathahResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalAudioKasrah: MutableLiveData<DataLatihanKasrahAudio> = MutableLiveData()
//    val dataSoalAudioKasrah: LiveData<DataLatihanKasrahAudio> get() = liveDataSoalAudioKasrah
//    fun getSoalAudioKasrah() {
//        Client.getSoalAudioKasrah().enqueue(object : Callback<BankSoalAudioKasrahResponse> {
//            override fun onResponse(call: Call<BankSoalAudioKasrahResponse>, response: Response<BankSoalAudioKasrahResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalAudioKasrah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalAudioKasrah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalAudioKasrahResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
//    private var liveDataSoalAudioDhammah: MutableLiveData<DataLatihanDhammahAudio> = MutableLiveData()
//    val dataSoalAudioDhammah: LiveData<DataLatihanDhammahAudio> get() = liveDataSoalAudioDhammah
//    fun getSoalAudioDhammah() {
//        Client.getSoalAudioDhammah().enqueue(object : Callback<BankSoalAudioDhammahResponse> {
//            override fun onResponse(call: Call<BankSoalAudioDhammahResponse>, response: Response<BankSoalAudioDhammahResponse>) {
//                if (response.isSuccessful) {
//                    liveDataSoalAudioDhammah.postValue(response.body()!!.data)
//
//                } else {
//                    liveDataSoalAudioDhammah.postValue(null)
//                    Log.e("Error", "onFailure: Error")
//                }
//            }
//
//            override fun onFailure(call: Call<BankSoalAudioDhammahResponse>, t: Throwable) {
//                Log.e("Error: ", "onFailure : ${t.message}")
//            }
//
//        })
//    }
}
