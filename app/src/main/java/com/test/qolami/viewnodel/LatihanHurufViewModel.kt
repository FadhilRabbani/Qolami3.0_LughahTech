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

}
