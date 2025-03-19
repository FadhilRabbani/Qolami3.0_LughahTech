package com.test.qolami.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentHomeBinding
import com.test.qolami.view.account.PopUpAkunFragment
import com.test.qolami.view.home.PopUpFiturSedangDikembankanFragment
import com.test.qolami.view.home.PopUpFragment
import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val getToken = sharedPreferences.getString("token", "")
        if (getToken!!.isNotEmpty()) {
            val getUsername = sharedPreferences.getString("name", "")
            binding.textNamaUser.text = getUsername.toString()
        }
        binding.buttonPelajaran.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pelajaranFragment)
        }
        binding.buttonLatihan.setOnClickListener {
            checkSudahLogin()
        }
        binding.imageView.setOnClickListener {
            if (getToken.isEmpty()) {
                val popUpAkun = PopUpAkunFragment()
                popUpAkun.show(childFragmentManager,"popupakun")
            }else {
                findNavController().navigate(R.id.action_homeFragment_to_akunFragment)
            }
        }
        binding.buttonQuiz.setOnClickListener {
            val popUpFiturFragment = PopUpFiturSedangDikembankanFragment()
            popUpFiturFragment.show(childFragmentManager, "popupfitur")
        }
    }
    private fun checkSudahLogin(){
        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "").toString()
        Log.i("info", token)
        if (token.isNotEmpty()) {
            sharedPreferences = requireContext().getSharedPreferences("Latihan", Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("Latihan", "Latihan").apply()
            findNavController().navigate(R.id.action_homeFragment_to_fragmentLatihan)
            Log.i("info", token)
        }else{
            val popUpFragment = PopUpFragment()
            popUpFragment.show(childFragmentManager, "PopUpFragment")
        }

    }




}