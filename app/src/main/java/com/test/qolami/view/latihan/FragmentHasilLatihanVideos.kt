package com.test.qolami.view.latihan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentHasilLatihanVideosBinding
//import com.test.qolami.viewnodel.ScoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHasilLatihanVideos : Fragment() {
    private lateinit var binding: FragmentHasilLatihanVideosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHasilLatihanVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jumlahBenar = arguments?.getInt("jumlahBenar", 0) ?: 0
        val jumlahSalah = arguments?.getInt("jumlahSalah", 0) ?: 0

        binding.nilaiBenar.text = jumlahBenar.toString()
        binding.nilaiSalah.text = jumlahSalah.toString()

        val sharedPref = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        binding.btnLanjutkan.setOnClickListener {
            val judul = sharedPref.getString("judulLatihanTampil", "") ?: ""

            val navController = findNavController()

            navController.popBackStack(R.id.fragmentLatihan, false)

            if (judul.contains("Kata", ignoreCase = true)) {
                navController.navigate(R.id.fragmentLatihanKata)
            } else {
                navController.navigate(R.id.fragmentLatihanHuruf)
            }
        }
    }

}
