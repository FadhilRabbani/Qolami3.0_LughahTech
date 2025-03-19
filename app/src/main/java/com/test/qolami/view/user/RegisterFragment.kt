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
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentRegisterBinding
import com.test.qolami.model.data.user.Data
import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentRegisterBinding
    private lateinit var userVM: UserViewModel
    private lateinit var sharedPreferences: SharedPreferences
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
        userVM = ViewModelProvider(this).get(UserViewModel::class.java)
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
        val username = binding.etName.text.toString()
        val password = binding.etPassword.text.toString()
        if (namaLengkap.isEmpty() || username.isEmpty() || password.isEmpty()){
            Toast.makeText(requireContext(), "Tolong Harap Di isi Semuanya", Toast.LENGTH_SHORT).show()
        }else{
            userVM.registerPost(
                dataNewUser = Data(
                    " ",
                    password,
                    namaLengkap,
                    username,
                    0
                )
            )
            userVM.dataPostUser.observe(viewLifecycleOwner){
                val sharedPref = sharedPreferences.edit()
                sharedPref.putString("username", username)
                sharedPref.putString("password", password)
                sharedPref.putString("namaprofile", namaLengkap)
                sharedPref.putString("idUser", it.data.id)
                Toast.makeText(requireContext(), "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show()
                sharedPref.apply()
            }
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }


}