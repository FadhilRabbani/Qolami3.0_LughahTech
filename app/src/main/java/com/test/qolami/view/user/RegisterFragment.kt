package com.test.qolami.view.user

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentRegisterBinding
import com.test.qolami.model.data.user.Data
import com.test.qolami.model.data.user.RegisterRequest
import com.test.qolami.model.network.RetrofitClient
import com.test.qolami.view.common.LoadingDialogFragment
//import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentRegisterBinding
    private var loadingDialog: LoadingDialogFragment? = null
    private lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var retrofitClient: RetrofitClient
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        userVM = ViewModelProvider(this).get(UserViewModel::class.java)
        sharedPreferences = requireContext().getSharedPreferences("register", Context.MODE_PRIVATE)
        binding.TombolBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.buttonDaftar.setOnClickListener {
            register()
        }
        binding.tvNavigateToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
    private  fun register(){
        val namaLengkap = binding.etNamalengkap.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        if (namaLengkap.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(requireContext(), "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(requireContext(), "Password tidak cocok", Toast.LENGTH_SHORT).show()
            return
        }

        val request = RegisterRequest(
            name = namaLengkap,
            email = email,
            password = password,
            password_confirmation = confirmPassword
        )
        loadingDialog = LoadingDialogFragment.newInstance("Mendaftarkan akun...")
        loadingDialog?.show(parentFragmentManager, "loading")

        binding.buttonDaftar.isEnabled = false
        lifecycleScope.launch {
            try {
                val response = retrofitClient.apiService.registerUser(request)
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(requireContext(), "Registrasi gagal: ${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Terjadi kesalahan: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }finally {
                loadingDialog?.dismiss()
                binding.buttonDaftar.isEnabled = true
            }
        }
    }


}