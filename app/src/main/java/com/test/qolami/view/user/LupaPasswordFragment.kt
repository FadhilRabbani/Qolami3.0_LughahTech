package com.test.qolami.view.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentLupaPasswordBinding
import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LupaPasswordFragment : Fragment() {
    private lateinit var binding: FragmentLupaPasswordBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLupaPasswordBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.imageBack.setOnClickListener {
            findNavController().navigate(R.id.action_lupaPasswordFragment_to_loginFragment)
        }
        binding.buttonSimpan.setOnClickListener {
            lupaPassword()
        }
    }
    private var testBoolean = false
    private fun lupaPassword(){
        val username = binding.etUsername.text.toString()
        val newPassword = binding.etMasukkanPassword.text.toString()
        val confrimPassword = binding.etMasukkanPasswordUlang.text.toString()
        userViewModel.dataPutLupaPassword.removeObservers(viewLifecycleOwner)
        if(username.isNotEmpty() && newPassword.isNotEmpty() && confrimPassword.isNotEmpty()){
            userViewModel.putLupaPassword(username, newPassword, confrimPassword)
            userViewModel.dataPutLupaPassword.observe(viewLifecycleOwner){
                if(it != null){
                    findNavController().navigate(R.id.action_lupaPasswordFragment_to_loginFragment)
                    Toast.makeText(context, "Ganti Password Berhasil!", Toast.LENGTH_SHORT).show()
                    testBoolean = true
                }else{
                    if(!testBoolean){
                        Toast.makeText(context,"Username Atau Password Salah!", Toast.LENGTH_SHORT).show()
                    }
                }
                testBoolean = true
            }
        }else{
            Toast.makeText(context, "Tolong Isi semua Field dengan benar", Toast.LENGTH_SHORT).show()
        }
    }

}