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
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentLoginBinding
import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var sharedPreferences: SharedPreferences

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
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
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
    //untuk variable menentukan masuk ke else username benar dan password salah
    private var isPositiveResponseReceived = false
    //fungsi login untuk mengecek apakah username atau password sudah benar atau belum
    private fun login(){
        userViewModel.dataPostLogin.removeObservers(viewLifecycleOwner)
        val emailInput = binding.etEmail.text.toString()
        val passwordInput = binding.etPassword.text.toString()
        if (emailInput.isNotEmpty() && passwordInput.isNotEmpty()) {
            userViewModel.loginPost(emailInput, passwordInput)
            userViewModel.dataPostLogin.observe(viewLifecycleOwner) { loginUserResponse ->
                Log.i("LoginStatus", "Status: $loginUserResponse")
                if(loginUserResponse != null) {
                    val test = loginUserResponse.data.token
                    val id = loginUserResponse.data._id
                    val profileName = loginUserResponse.data.username
                    val sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putString("token", test).apply()
                    sharedPreferences.edit().putString("id", id).apply()
                    sharedPreferences.edit().putString("name", profileName).apply()
                    Log.i("observer", "1")
                    Log.i("id", "$id")
                    Toast.makeText(context, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    isPositiveResponseReceived = true
                } else {
                    if (!isPositiveResponseReceived) {
                        Log.i("observer", "$isPositiveResponseReceived")
                        Toast.makeText(context, "Username atau Password Salah!", Toast.LENGTH_SHORT).show()
                    }
                }
                isPositiveResponseReceived = true
            }
        }else{
            Toast.makeText(context, "Harap isi username dan password dengan benar!", Toast.LENGTH_SHORT).show()
        }
    }

}