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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentDetailLatihanHuruf : Fragment() {
    private lateinit var binding: FragmentDetailLatihanHurufBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferences2: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailLatihanHurufBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        sharedPreferences2 = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        binding.imageBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentLatihanHuruf)
        }

        // Ambil latihanId dari argument bundle
        val latihanId = arguments?.getInt("latihanId", -1) ?: -1
        sharedPreferences.edit().putInt("latihanId", latihanId).apply()

        // Data untuk menampilkan judul dan latihan
        val latihan = arguments?.getString("latihan")
        val judulLatihan = arguments?.getString("judulLatihan")
        val judulLatihanVideos = arguments?.getString("judulLatihanVideos")
        val judulLatihanAudio = arguments?.getString("judulLatihanAudio")

        val namaHuruf = when (latihanId) {
            1 -> "Fathah"
            2 -> "Kasrah"
            3 -> "Dhammah"
            4 -> "Fathahtain"
            5 -> "Kasrahtain"
            6 -> "Dhammahtain"
            else -> "Tidak Diketahui"
        }

        val judulTampil = "Latihan Huruf $namaHuruf"

        // Navigasi saat klik video
        binding.ivLatihanVideo.setOnClickListener {
            val latihanId = sharedPreferences.getInt("latihanId", -1)
            if (latihanId != -1) {
                val editor = sharedPreferences.edit()
                editor.putString("latihanVideo", namaHuruf)
                editor.putString("judulLatihanTampil", judulTampil)
                editor.apply()

                Log.d("SharedPref", "judulLatihanTampil = $judulTampil")
                findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanVideos)
            } else {
                Log.e("FragmentDetailLatihanHuruf", "latihanId tidak ditemukan atau tidak valid!")
            }
        }


        // Navigasi saat klik audio
        binding.ivLatihanAudio.setOnClickListener {
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
            findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanAudio)
        }
    }

    override fun onResume() {
        super.onResume()
        val latihanId = sharedPreferences.getInt("latihanId", -1)
        if (latihanId != -1) {
            // Memuat soal berdasarkan latihanId
            loadSoal(latihanId)
        } else {
            Log.e("FragmentDetailLatihanHuruf", "latihanId tidak ditemukan!")
        }
    }

    private fun loadSoal(latihanId: Int) {
        when (latihanId) {
            1 -> {
                // Logika untuk memuat soal video/audio
                Log.d("FragmentDetailLatihanHuruf", "Memuat soal video untuk latihanId $latihanId")
            }
            2 -> {
                // Logika untuk memuat soal lainnya
            }
            else -> {
                Log.e("FragmentDetailLatihanHuruf", "latihanId tidak dikenal: $latihanId")
            }
        }
    }

}
