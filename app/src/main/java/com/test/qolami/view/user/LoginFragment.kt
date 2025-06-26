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
import com.test.qolami.model.network.RestfulApi
import com.test.qolami.model.network.RetrofitClient
import com.test.qolami.view.common.LoadingDialogFragment
//import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private var loadingDialog: LoadingDialogFragment? = null
    private lateinit var sharedPreferences: SharedPreferences

    @Inject
    @Named("unauthenticated")
    lateinit var unauthenticatedApiService: RestfulApi.ApiService

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

        sharedPreferences = requireContext().getSharedPreferences("register", Context.MODE_PRIVATE)

        //pindah ke register fragment
        binding.textDaftar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        //pindah ke fragment lupa password
        binding.lupaPassword.setOnClickListener {
            val bundle = Bundle().apply {
                putString("source_fragment", "login")
            }
            findNavController().navigate(R.id.action_loginFragment_to_send_otp, bundle)
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

        binding.buttonMasuk.isEnabled = false

        val loginRequest = LoginRequest(email, password)
        loadingDialog = LoadingDialogFragment.newInstance("Sedang masuk ke akun...`")
        loadingDialog?.show(parentFragmentManager, "loading")
        lifecycleScope.launch {
            try {
                val response = unauthenticatedApiService.loginUser(loginRequest)
                if (response.isSuccessful) {
                    val loginData = response.body()
                    if (loginData != null) {
                        Log.d("LOGIN_DEBUG", "User ID dari login response: ${loginData.user.id}")
                        val sharedPref = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putString("token", loginData.token)
                            putInt("userId", loginData.user.id)
                            putString("userName", loginData.user.name)
                            putString("userEmail", loginData.user.email)
                            apply()
                        }
                        Log.d("LOGIN_SAVE", "Token disimpan: ${loginData.token}")
                        Toast.makeText(requireContext(), "Login berhasil!", Toast.LENGTH_SHORT).show()
                        loadingDialog?.dismiss()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                } else {
                    loadingDialog?.dismiss()
                    Toast.makeText(requireContext(), "Login gagal: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                loadingDialog?.dismiss()
                Toast.makeText(requireContext(), "Terjadi kesalahan: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            } finally {
                loadingDialog?.dismiss()
                binding.buttonMasuk.isEnabled = true
            }
        }
    }


}