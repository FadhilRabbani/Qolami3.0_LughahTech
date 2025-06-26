package com.test.qolami.viewnodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.qolami.model.network.RestfulApi
import com.test.qolami.view.account.data.UpdateNameRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class UserViewModel @Inject constructor(
    @Named("authenticated") private val apiService: RestfulApi.ApiService // Menggunakan ApiService yang terautentikasi
) : ViewModel() {

    private val _updateResponse = MutableLiveData<String>()
    val updateResponse: LiveData<String> get() = _updateResponse

    fun updateUserName(userId: Int, newName: String) {
        viewModelScope.launch {
            try {
                // Mengirim request untuk mengupdate nama
                val response = apiService.updateUserName(UpdateNameRequest(newName))

                if (response.isSuccessful) {
                    // Berhasil update nama
                    _updateResponse.value = response.body()?.message ?: "Nama berhasil diperbarui"
                } else {
                    // Gagal update nama
                    _updateResponse.value = "Gagal mengubah nama, coba lagi."
                    Log.e("UserViewModel", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Tangani kesalahan jaringan atau lainnya
                _updateResponse.value = "Terjadi kesalahan: ${e.message}"
                Log.e("UserViewModel", "Exception: ${e.message}")
            }
        }
    }
}

