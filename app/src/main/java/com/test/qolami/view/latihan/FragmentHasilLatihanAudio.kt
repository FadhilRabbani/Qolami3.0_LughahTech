package com.test.qolami.view.latihan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentHasilLatihanAudioBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHasilLatihanAudio : Fragment() {
    private lateinit var binding: FragmentHasilLatihanAudioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHasilLatihanAudioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jumlahBenar = arguments?.getInt("jumlahBenarAudio", 0) ?: 0
        val jumlahSalah = arguments?.getInt("jumlahSalahAudio", 0) ?: 0

        binding.nilaiBenar.text = jumlahBenar.toString()
        binding.nilaiSalah.text = jumlahSalah.toString()

        binding.btnLanjutkan.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHasilLatihanAudio_to_fragmentDetailLatihanHuruf)
        }
    }
}
