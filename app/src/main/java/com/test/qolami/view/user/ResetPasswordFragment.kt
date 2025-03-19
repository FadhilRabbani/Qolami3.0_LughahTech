package com.test.qolami.view.user

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentResetPasswordBinding
import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment() {
    private lateinit var binding : FragmentResetPasswordBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var userViewModel: UserViewModel
    private var testBoolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetPasswordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val id = sharedPreferences.getString("id", "")

        binding.imageBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.buttonSimpan.setOnClickListener {
            val newPassword = binding.etMasukkanPassword.text.toString()
            val repeatPassword = binding.etMasukkanPasswordUlang.text.toString()
            userViewModel.dataPassword.removeObservers(viewLifecycleOwner)
            if (newPassword.isNotEmpty() && repeatPassword.isNotEmpty()) {
                userViewModel.patchUserPassword(id!!, newPassword, repeatPassword)
                userViewModel.dataPassword.observe(viewLifecycleOwner) {
                    if (it != null) {
                        findNavController().navigate(R.id.action_resetPasswordFragment_to_homeFragment)
                        Toast.makeText(context, "Ganti Password Berhasil!", Toast.LENGTH_SHORT)
                            .show()
                        testBoolean = true
                    } else {
                        if (!testBoolean) {
                            Toast.makeText(
                                context,
                                "Ganti Password Tidak Berhasil!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    testBoolean = true
                }
            } else {
                Toast.makeText(context, "Tolong Isi semua Field dengan benar", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

}