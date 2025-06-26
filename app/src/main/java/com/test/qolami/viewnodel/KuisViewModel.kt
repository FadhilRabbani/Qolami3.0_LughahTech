package com.test.qolami.viewnodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.qolami.view.kuis.JawabanData
import com.test.qolami.view.kuis.JawabanRequest
import com.test.qolami.view.kuis.KuisItem
import com.test.qolami.view.kuis.KuisRepository
import com.test.qolami.view.kuis.SoalKuis
import com.test.qolami.view.latihan.LatihanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KuisViewModel @Inject constructor(private val repo: LatihanRepository, private val repokuis : KuisRepository): ViewModel() {
    private val _soalList = MutableLiveData<List<SoalKuis>>()
    val soalList: LiveData<List<SoalKuis>> get() = _soalList

    fun loadKuis(kategori: String, kuisId: Int) {
        viewModelScope.launch {
            try {
                val response = repo.getSoalKuis(kategori, kuisId)
                if (response.isSuccessful) {
                    _soalList.value = response.body()?.soal ?: emptyList()
                } else {
                    Log.e("KUIS", "Gagal: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("KUIS", "Error: ", e)
            }
        }
    }

    private val _hasilKuis = MutableLiveData<JawabanData>()
    val hasilKuis: LiveData<JawabanData> get() = _hasilKuis

    fun submitJawabanKuis(jawabanRequest: JawabanRequest) {
        viewModelScope.launch {
            try {
                val response = repo.submitJawabanKuis(jawabanRequest)
                if (response.isSuccessful) {
                    _hasilKuis.value = response.body()?.data
                } else {
                    Log.e("SUBMIT_KUIS", "Gagal submit: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("SUBMIT_KUIS", "Error: ", e)
            }
        }
    }
    private val _listKuis = MutableLiveData<List<KuisItem>>()
    val listKuis: LiveData<List<KuisItem>> = _listKuis

    fun fetchKuis() {
        viewModelScope.launch {
            try {
                val response = repokuis.getListKuis()
                if (response.isSuccessful) {
                    val kuisList = response.body()?.data ?: emptyList()
                    _listKuis.postValue(kuisList)
                } else {
                    Log.e("KuisViewModel", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("KuisViewModel", "Exception: ${e.message}")
            }
        }
    }
}
