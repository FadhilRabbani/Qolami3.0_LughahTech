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
import com.test.qolami.viewnodel.ScoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHasilLatihanVideos : Fragment() {
    private lateinit var binding: FragmentHasilLatihanVideosBinding
    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHasilLatihanVideosBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val hasilBenarVideos = this.arguments!!.getInt("JumlahBenarVideos")
        val hasilSalahVideos = this.arguments!!.getInt("JumlahSalahVideos")
        val title = this.arguments!!.getString("titleVideos")
        val subtitle = this.arguments!!.getString("subtitleVideos")
        Log.i("benar", "$hasilBenarVideos")
        Log.i("salah", "$hasilSalahVideos")
        Log.i("title", "$subtitle")
        binding.nilaiBenar.text = hasilBenarVideos.toString()
        binding.nilaiSalah.text = hasilSalahVideos.toString()
        binding.btnLanjutkan.setOnClickListener {
            if(subtitle == "Huruf Berharakat Fathah"){
                postScoreFathah()
                val bundle = Bundle()
                bundle.putString("judulLatihanVideos", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanVideos_to_fragmentDetailLatihanHuruf, bundle)
            }else if(subtitle == "Huruf Berharakat Kasrah"){
                postScoreKasrah()
                val bundle = Bundle()
                bundle.putString("judulLatihanVideos", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanVideos_to_fragmentDetailLatihanHuruf, bundle)
            }else if(subtitle == "Huruf Hijaiyah"){
                postScoreHijaiyah()
                val bundle = Bundle()
                bundle.putString("judulLatihanVideos", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanVideos_to_fragmentDetailLatihanHuruf, bundle)
            }else if(subtitle == "Huruf Berharakat Dhammah"){
                postScoreDhammah()
                val bundle = Bundle()
                bundle.putString("judulLatihanVideos", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanVideos_to_fragmentDetailLatihanHuruf, bundle)
            }

        }

    }
    private fun postScoreHijaiyah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("JumlahBenarVideos") * 10
        scoreViewModel.patchScoreHijaiyahVideo(id!!, jumlahBenar)
    }
    private fun postScoreFathah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("JumlahBenarVideos") * 10
        scoreViewModel.patchScoreFathahVideo(id!!, jumlahBenar)
    }
    private fun postScoreKasrah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("JumlahBenarVideos") * 10
        scoreViewModel.patchScoreKasrahVideo(id!!, jumlahBenar)
    }
    private fun postScoreDhammah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("JumlahBenarVideos") *10
        scoreViewModel.patchScoreDhammahVideo(id!!, jumlahBenar)
    }



}