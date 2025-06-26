package com.test.qolami.view.latihan

import android.annotation.SuppressLint
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
import com.test.qolami.databinding.FragmentDetailLatihanHurufBinding
import com.test.qolami.databinding.FragmentDetailLatihanKataBinding
import com.test.qolami.databinding.FragmentLatihanKataBinding
//import com.test.qolami.viewnodel.ScoreViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentDetailLatihanKata : Fragment() {
    private lateinit var binding: FragmentDetailLatihanKataBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferences2: SharedPreferences
    //    private lateinit var scoreViewModel: ScoreViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailLatihanKataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        sharedPreferences2 = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        binding.imageBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetailLatihanKata_to_fragmentLatihanKata)
        }

        val latihanId = arguments?.getInt("latihanId", -1) ?: -1
        sharedPreferences.edit().putInt("latihanId", latihanId).apply()

        val latihan = arguments?.getString("latihan")
        val judulLatihan = arguments?.getString("judulLatihan")
        val judulLatihanVideos = arguments?.getString("judulLatihanVideos")
        val judulLatihanAudio = arguments?.getString("judulLatihanAudio")

        val namaHuruf = when (latihanId) {
            7 -> "Fathah"
            8 -> "Kasrah"
            9 -> "Dhammah"
            10 -> "Fathahtain"
            11 -> "Kasrahtain"
            12 -> "Dhammahtain"
            else -> "Tidak Diketahui"
        }

        val judulTampil = "Latihan Kata $namaHuruf"

        // Navigasi saat klik video
        binding.ivLatihanVideo.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("latihanVideo", namaHuruf)
            editor.putString("judulLatihanTampil", judulTampil)
            editor.apply()

            Log.d("SharedPref", "judulLatihanTampil = $judulTampil")
            findNavController().navigate(R.id.action_fragmentDetailLatihanKata_to_fragmentSoalLatihanVideo)
        }

        binding.ivLatihanAudio.setOnClickListener {
            val editor = sharedPreferences.edit()

            when {
                latihan != null -> sharedPreferences.edit().putString("latihanAudio", latihan)
                    .apply()

                judulLatihan != null -> sharedPreferences.edit()
                    .putString("latihanAudio", judulLatihan).apply()

                judulLatihanVideos != null -> sharedPreferences.edit()
                    .putString("latihanAudio", judulLatihanVideos).apply()

                judulLatihanAudio != null -> sharedPreferences.edit()
                    .putString("latihanAudio", judulLatihanAudio).apply()
            }
            editor.putString("judulLatihanTampil", judulTampil)
            editor.apply()
            findNavController().navigate(R.id.action_fragmentDetailLatihanKata_to_fragmentSoalLatihanAudio)
        }
    }
}