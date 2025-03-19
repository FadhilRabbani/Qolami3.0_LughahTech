package com.test.qolami.view.latihan

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
import com.test.qolami.databinding.FragmentHasilLatihanAudioBinding
import com.test.qolami.viewnodel.ScoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHasilLatihanAudio : Fragment() {
    private lateinit var binding: FragmentHasilLatihanAudioBinding
    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHasilLatihanAudioBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val hasilBenarAudio = this.arguments!!.getInt("jumlahBenarAudio")
        val hasilSalahAudio = this.arguments!!.getInt("jumlahSalahAudio")
        val title = this.arguments!!.getString("titleAudio")
        val subtitle = this.arguments!!.getString("subtitleAudio")
        Log.i("benar", "$hasilBenarAudio")
        Log.i("salah", "$hasilSalahAudio")
        binding.nilaiBenar.text = hasilBenarAudio.toString()
        binding.nilaiSalah.text = hasilSalahAudio.toString()
        binding.btnLanjutkan.setOnClickListener {
            if(subtitle == "Huruf Berharakat Fathah"){
                postScoreFathah()
                val bundle = Bundle()
                bundle.putString("judulLatihanAudio", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanAudio_to_fragmentDetailLatihanHuruf, bundle)
            }else if(subtitle == "Huruf Berharakat Kasrah"){
                postScoreKasrah()
                val bundle = Bundle()
                bundle.putString("judulLatihanAudio", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanAudio_to_fragmentDetailLatihanHuruf, bundle)
            }else if(subtitle == "Huruf Hijaiyah"){
                postScoreHijaiyah()
                val bundle = Bundle()
                bundle.putString("judulLatihanAudio", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanAudio_to_fragmentDetailLatihanHuruf, bundle)
            }else if(subtitle == "Huruf Berharakat Dhammah"){
                postScoreDhammah()
                val bundle = Bundle()
                bundle.putString("judulLatihanAudio", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihanAudio_to_fragmentDetailLatihanHuruf, bundle)
            }

        }

    }
    private fun postScoreHijaiyah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("jumlahBenarAudio") * 10
        scoreViewModel.patchScoreHijaiyahAudio(id!!, jumlahBenar)
    }
    private fun postScoreFathah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("jumlahBenarAudio") * 10
        scoreViewModel.patchScoreFathahAudio(id!!, jumlahBenar)

    }
    private fun postScoreKasrah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("jumlahBenarAudio") * 10
        scoreViewModel.patchScoreKasrahAudio(id!!, jumlahBenar)

    }
    private fun postScoreDhammah(){
        val id = sharedPreferences.getString("id", "")
        val jumlahBenar = this.arguments!!.getInt("jumlahBenarAudio") *10
        scoreViewModel.patchScoreDhammahAudio(id!!, jumlahBenar)

    }

}