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
import com.test.qolami.viewnodel.ScoreViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentDetailLatihanHuruf : Fragment() {
    private lateinit var binding: FragmentDetailLatihanHurufBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferences2: SharedPreferences
    private lateinit var scoreViewModel: ScoreViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailLatihanHurufBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        sharedPreferences2 = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        binding.imageBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentLatihanHuruf)
        }
        val latihan = this.arguments?.getString("latihan")
        val judulLatihan = this.arguments?.getString("judulLatihan")
        val judulLatihanVideos = this.arguments?.getString("judulLatihanVideos")
        val judulLatihanAudio = this.arguments?.getString("judulLatihanAudio")
        val id = sharedPreferences2.getString("id", "")
        Log.i("id", "$latihan" )
        Log.i("judul", "$judulLatihan" )
            if (latihan != null) {
                if (latihan == "Latihan 1") {
                    scoreViewModel.getScoreHijaiyah(id!!)
                    scoreViewModel.dataGetScore.observe(viewLifecycleOwner) {
                        binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                        binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                        binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                    }
                }else if (latihan == "Latihan 2") {
                    scoreViewModel.getScoreFathah(id!!)
                    scoreViewModel.dataGetScoreFathah.observe(viewLifecycleOwner) {
                        binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                        binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                        binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                    }
                }else if (latihan == "Latihan 3"){
                    scoreViewModel.getScoreKasrah(id!!)
                    scoreViewModel.dataGetScoreKasrah.observe(viewLifecycleOwner) {
                        binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                        binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                        binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                    }
                }else if (latihan == "Latihan 4"){
                    scoreViewModel.getScoreDhammah(id!!)
                    scoreViewModel.dataGetScoreDhammah.observe(viewLifecycleOwner) {
                        binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                        binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                        binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                    }
                }
            }else{
                if (judulLatihanAudio != null ) {
                    if (judulLatihanAudio == "Latihan 1") {
                        scoreViewModel.getScoreHijaiyah(id!!)
                        scoreViewModel.dataGetScore.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }else if (judulLatihanAudio == "Latihan 2") {
                        scoreViewModel.getScoreFathah(id!!)
                        scoreViewModel.dataGetScoreFathah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }else if (judulLatihanAudio == "Latihan 3"){
                        scoreViewModel.getScoreKasrah(id!!)
                        scoreViewModel.dataGetScoreKasrah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }else if (judulLatihanAudio == "Latihan 4"){
                        scoreViewModel.getScoreDhammah(id!!)
                        scoreViewModel.dataGetScoreDhammah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }
                }else if(judulLatihan!=null){
                    if (judulLatihan == "Latihan 1") {
                        scoreViewModel.getScoreHijaiyah(id!!)
                        scoreViewModel.dataGetScore.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }else if (judulLatihan == "Latihan 2") {
                        scoreViewModel.getScoreFathah(id!!)
                        scoreViewModel.dataGetScoreFathah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }else if (judulLatihan == "Latihan 3"){
                        scoreViewModel.getScoreKasrah(id!!)
                        scoreViewModel.dataGetScoreKasrah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }else if (judulLatihan == "Latihan 4"){
                        scoreViewModel.getScoreDhammah(id!!)
                        scoreViewModel.dataGetScoreDhammah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }
                }else if (judulLatihanVideos!=null){
                    if (judulLatihanVideos == "Latihan 1") {
                        scoreViewModel.getScoreHijaiyah(id!!)
                        scoreViewModel.dataGetScore.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    } else if (judulLatihanVideos == "Latihan 2") {
                        scoreViewModel.getScoreFathah(id!!)
                        scoreViewModel.dataGetScoreFathah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    } else if (judulLatihanVideos == "Latihan 3") {
                        scoreViewModel.getScoreKasrah(id!!)
                        scoreViewModel.dataGetScoreKasrah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    } else if (judulLatihanVideos == "Latihan 4") {
                        scoreViewModel.getScoreDhammah(id!!)
                        scoreViewModel.dataGetScoreDhammah.observe(viewLifecycleOwner) {
                            binding.tvNilaiLatihanGambar.text = it.scoreImage.toString() + "/100"
                            binding.tvNilaiLatihanVideo.text = it.scoreVideo.toString() + "/100"
                            binding.tvNilaiLatihanAudio.text = it.scoreAudio.toString() + "/100"
                        }
                    }
                }
            }


        binding.ivLatihanGambar.setOnClickListener {
            if(latihan != null) {
                sharedPreferences.edit().putString("latihan", latihan).apply()
                findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanImage)
            }else{
                if (judulLatihan != null) {
                    sharedPreferences.edit().putString("latihan", judulLatihan).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanImage)
                }else if (judulLatihanVideos != null){
                    sharedPreferences.edit().putString("latihan", judulLatihanVideos).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanImage)
                }else if (judulLatihanAudio != null){
                    sharedPreferences.edit().putString("latihan", judulLatihanAudio).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanImage)
                }
            }
        }
        binding.ivLatihanVideo.setOnClickListener {
            if(latihan != null) {
                sharedPreferences.edit().putString("latihanVideo", latihan).apply()
                findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanVideos)
            }else{
                if (judulLatihan != null) {
                    sharedPreferences.edit().putString("latihanVideo", judulLatihan).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanVideos)
                }else if (judulLatihanVideos != null){
                    sharedPreferences.edit().putString("latihanVideo", judulLatihanVideos).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanVideos)
                }else if (judulLatihanAudio != null){
                    sharedPreferences.edit().putString("latihanVideo", judulLatihanAudio).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanVideos)
                }
            }
        }
        binding.ivLatihanAudio.setOnClickListener {
            if(latihan != null){
                sharedPreferences.edit().putString("latihanAudio", latihan).apply()
                findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanAudio)
            }else{
                if (judulLatihan != null) {
                    sharedPreferences.edit().putString("latihanAudio", judulLatihan).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanAudio)
                }else if (judulLatihanVideos != null){
                    sharedPreferences.edit().putString("latihanAudio", judulLatihanVideos).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanAudio)
                }else if (judulLatihanAudio != null){
                    sharedPreferences.edit().putString("latihanAudio", judulLatihanAudio).apply()
                    findNavController().navigate(R.id.action_fragmentDetailLatihanHuruf_to_fragmentSoalLatihanAudio)
                }
            }
        }
    }


}