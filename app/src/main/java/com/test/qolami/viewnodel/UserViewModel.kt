package com.test.qolami.viewnodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.qolami.model.data.user.*
import com.test.qolami.model.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val Client:RestfulApi): ViewModel() {
    //Untuk Mengatur Register Response api
    private var livePatchUser: MutableLiveData<GantiProfileNameResponse> = MutableLiveData()
     var dataUser: LiveData<GantiProfileNameResponse> = livePatchUser
    fun patchUser(userId: String, username:String) {
        Client.patchUser(userId, username).enqueue(object : Callback<GantiProfileNameResponse> {
            override fun onResponse(call: Call<GantiProfileNameResponse>, response: Response<GantiProfileNameResponse>) {
                if (response.isSuccessful) {
                    livePatchUser.postValue(response.body()!!)
                } else {
                    Log.e("Error", "onFailure: ${response.body()?.message}")
                }
            }

            override fun onFailure(call: Call<GantiProfileNameResponse>, t: Throwable) {
                Log.e("Error: ", "dfdgd : ${t.message}")
            }

        })
    }
    private var livePutPassword: MutableLiveData<GantiPasswordResponse> = MutableLiveData()
    var dataPassword: LiveData<GantiPasswordResponse> = livePutPassword
    fun patchUserPassword(userId: String, password: String, newPassword: String) {
        Client.putGantiPassword(userId, password, newPassword).enqueue(object : Callback<GantiPasswordResponse> {
            override fun onResponse(call: Call<GantiPasswordResponse>, response: Response<GantiPasswordResponse>) {
                if (response.isSuccessful) {
                    livePutPassword.postValue(response.body()!!)
                } else {
                    Log.e("Error", "onFailure: ${response.body()?.message}")
                }
            }

            override fun onFailure(call: Call<GantiPasswordResponse>, t: Throwable) {
                Log.e("Error: ", "dfdgd : ${t.message}")
            }

        })
    }
    private var liveDataUser: MutableLiveData<NewUser> = MutableLiveData()
    val dataPostUser: LiveData<NewUser> get() = liveDataUser
    fun registerPost(dataNewUser: Data) {
        Client.postRegister(dataNewUser).enqueue(object : Callback<NewUser> {
            override fun onResponse(call: Call<NewUser>, response: Response<NewUser>) {
                if (response.isSuccessful) {
                    liveDataUser.postValue(response.body())

                } else {
                    liveDataUser.postValue(null)
                    Log.e("Error", "onFailure: ${response.body()?.message}")
                }
            }

            override fun onFailure(call: Call<NewUser>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }


    //Untuk mengatur Login Response Api
    private var liveDataLogin: MutableLiveData<LoginUserResponse> = MutableLiveData()
    val dataPostLogin: LiveData<LoginUserResponse> get() = liveDataLogin
    private val liveLoadData = MutableLiveData<Boolean>()
    fun loginPost(email: String, password: String) {
        liveLoadData.value = true
        Client.postLogin(email, password).enqueue(object : Callback<LoginUserResponse> {
            override fun onResponse(
                call: Call<LoginUserResponse>,
                response: Response<LoginUserResponse>
            ) {
                if (response.isSuccessful) {
                    liveLoadData.value = false
                    liveDataLogin.postValue(response.body())
                } else {
                    liveLoadData.value = false
                    liveDataLogin.postValue(null)
                    Log.e("Error", "onFailure 1: ${response.body()?.message}")
                }
            }

            override fun onFailure(call: Call<LoginUserResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }

    //Untuk Mengatur Lupa Password Api
    private var liveDataLupaPassword: MutableLiveData<LupaPasswordResponse> = MutableLiveData()
    val dataPutLupaPassword: LiveData<LupaPasswordResponse> get() = liveDataLupaPassword
    fun putLupaPassword(username: String, newPassword:String, repeatNewPassword:String){
        Client.putLupaPassword(username, newPassword, repeatNewPassword).enqueue(object : Callback<LupaPasswordResponse>{
            override fun onResponse(
                call: Call<LupaPasswordResponse>,
                response: Response<LupaPasswordResponse>
            ) {
                if(response.isSuccessful){
                    liveDataLupaPassword.postValue(response.body())
                }else{
                    liveDataLupaPassword.postValue(null)
                    Log.e("Error","OnFailure : ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<LupaPasswordResponse>, t: Throwable) {
                Log.e("Error: ", "onFailure : ${t.message}")
            }

        })
    }
}