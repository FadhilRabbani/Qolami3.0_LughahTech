package com.test.qolami.viewnodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.qolami.model.network.RetrofitClient
import com.test.qolami.view.user.EmailRequest
import com.test.qolami.view.user.ResetPasswordRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(
    @Named("unauthenticated_client") private val retrofitClient: RetrofitClient
) : ViewModel() {

    val message = MutableLiveData<String>()
    val error = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun sendOtp(email: String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = retrofitClient.apiService.sendOtp(EmailRequest(email))
                if (response.isSuccessful) {
                    message.value = response.body()?.message
                } else {
                    val errorBody = response.errorBody()?.string()
                    val errorMessage = try {
                        JSONObject(errorBody ?: "").getString("message")
                    } catch (e: Exception) {
                        "Gagal mengirim OTP (${response.code()})"
                    }
                    error.value = errorMessage
                }
            } catch (e: Exception) {
                error.value = e.localizedMessage ?: "Terjadi kesalahan tidak diketahui"
            }
            isLoading.value = false
        }
    }

    fun resetPassword(email: String, otp: String, pass: String, confirm: String) {
        viewModelScope.launch {
            try {
                val response = retrofitClient.apiService.changePassword(
                    ResetPasswordRequest(email, otp, pass, confirm)
                )
                if (response.isSuccessful) {
                    // Jika sukses dan bisa dibaca
                    message.value = response.body()?.message
                } else {
                    // Jangan langsung panggil errorBody?.string() karena ini raw dan bisa error
                    val errorBody = response.errorBody()?.string()
                    error.value = "Gagal: $errorBody"
                }
            } catch (e: Exception) {
                error.value = "Exception: ${e.localizedMessage}"
            }
        }
    }

}
