package com.test.qolami.viewnodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.qolami.R
import com.test.qolami.view.latihan.DataLatihan.SoalAudio
import com.test.qolami.view.latihan.DataLatihan.SoalVideo
import com.test.qolami.view.latihan.DataLatihanKata
import kotlinx.coroutines.launch
import com.test.qolami.view.latihan.LatihanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LatihanKataViewModel@Inject constructor (private val repository: LatihanRepository): ViewModel() {
    val listData = arrayListOf(
        DataLatihanKata(7, R.drawable.img_fathah, "Latihan 1","Kata Berharakat Fathah"),
        DataLatihanKata(8, R.drawable.img_kasroh, "Latihan 2","Kata Berharakat Kasrah"),
        DataLatihanKata(9, R.drawable.img_dhammah, "Latihan 3","Kata Berharakat Dhammah"),
        /*DataLatihanKata(4, R.drawable.img_fathahtain, "Latihan 4","Huruf Berharakat Fathahtain"),
        DataLatihanKata(5, R.drawable.img_kasrahtain, "Latihan 5","Huruf Berharakat Kasrahtain"),
        DataLatihanKata(6, R.drawable.dhammahtain, "Latihan 6","Huruf Berharakat Dhammahtain"),
        DataLatihanKata(R.drawable.img_sukun, "Pelajaran 7","Huruf Berharakat Sukun"),
        DataLatihanKata(R.drawable.img_tasyjid, "Pelajaran 8","Huruf Berharakat Tasydid")*/
    )
    val getDataKata : MutableLiveData<List<DataLatihanKata>> = MutableLiveData()
    fun getData(){
        getDataKata.value = listData
    }

    val soalVideos = MutableLiveData<List<SoalVideo>>()  // Reuse data class SoalVideo

    fun loadSoalKata(latihanId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getSoalLatihanVideo(latihanId)  // Reuse endpoint
                if (response.isSuccessful) {
                    soalVideos.value = response.body()?.soal ?: emptyList()
                } else {
                    Log.e("LatihanKataVM", "Gagal: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("LatihanKataVM", "Error: ${e.message}")
            }
        }
    }
    val soalAudios = MutableLiveData<List<SoalAudio>>()

    fun loadSoalAudio(latihanId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getSoalLatihanAudio(latihanId)
                if (response.isSuccessful) {
                    soalAudios.postValue(response.body()?.soal ?: emptyList())
                } else {
                    Log.e("LatihanKataVM", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("LatihanKataVM", "Exception: ${e.message}")
            }
        }
    }

}