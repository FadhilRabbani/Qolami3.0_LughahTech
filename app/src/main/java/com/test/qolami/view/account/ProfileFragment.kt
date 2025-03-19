package com.test.qolami.view.account

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentProfileBinding
import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var getId = sharedPreferences.getString("id", "")
        var getProfileName = sharedPreferences.getString("name", "")
        binding.etNamalengkap.setText(getProfileName)
        binding.icBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.buttonDaftar.setOnClickListener {
            binding.etNamalengkap.isEnabled = true
        }
        binding.buttonSimpan.setOnClickListener {
            var updateProfileName = binding.etNamalengkap.text.toString()
            userViewModel.patchUser(getId!!, updateProfileName!!)
            sharedPreferences.edit().putString("name", updateProfileName).apply()
            binding.etNamalengkap.isEnabled = false
        }
    }


}