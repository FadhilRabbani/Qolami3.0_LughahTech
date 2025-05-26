package com.test.qolami.view.user

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentLoginBinding
import com.test.qolami.model.data.user.LoginRequest
import com.test.qolami.model.network.RetrofitClient
//import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
//    private lateinit var userViewModel: UserViewModel
    private lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var retrofitClient: RetrofitClient
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        sharedPreferences = requireContext().getSharedPreferences("register", Context.MODE_PRIVATE)
        //pindah ke register fragment
        binding.textDaftar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        //pindah ke fragment lupa password
        binding.lupaPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_lupaPasswordFragment)
        }
        //pindah ke home fragment
        binding.buttonMasuk.setOnClickListener {
            login()

        }
        binding.textMasuktanpalogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }
    private fun login() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Harap isi email dan password!", Toast.LENGTH_SHORT).show()
            return
        }

        val loginRequest = LoginRequest(email, password)
        lifecycleScope.launch {
            try {
                val response = retrofitClient.apiService.loginUser(loginRequest)  // Gunakan apiService yang sudah disuntikkan
                if (response.isSuccessful) {
                    val loginData = response.body()
                    if (loginData != null) {
                        val sharedPref = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putString("token", loginData.token)
                            putInt("userId", loginData.user.id)
                            putString("userName", loginData.user.name)
                            putString("userEmail", loginData.user.email)
                            apply()
                        }
                        Toast.makeText(requireContext(), "Login berhasil!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                } else {
                    Toast.makeText(requireContext(), "Login gagal: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Terjadi kesalahan: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        }
//        lifecycleScope.launch {
//            try {
//                val response = RetrofitClient.instance.loginUser(loginRequest)
//                if (response.isSuccessful) {
//                    val loginData = response.body()
//                    if (loginData != null) {
//                        val sharedPref = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
//                        with(sharedPref.edit()) {
//                            putString("token", loginData.token)
//                            putInt("userId", loginData.user.id)
//                            putString("userName", loginData.user.name)
//                            putString("userEmail", loginData.user.email)
//                            apply()
//                        }
//                        Toast.makeText(requireContext(), "Login berhasil!", Toast.LENGTH_SHORT).show()
//                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//                    }
//                } else {
//                    Toast.makeText(requireContext(), "Login gagal: ${response.code()}", Toast.LENGTH_SHORT).show()
//                }
//            } catch (e: Exception) {
//                Toast.makeText(requireContext(), "Terjadi kesalahan: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
//            }
//        }
    }


}