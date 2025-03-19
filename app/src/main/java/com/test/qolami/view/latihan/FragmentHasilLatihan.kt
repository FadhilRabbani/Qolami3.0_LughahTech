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
import com.test.qolami.databinding.FragmentHasilLatihanBinding
import com.test.qolami.viewnodel.ScoreViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentHasilLatihan : Fragment() {
    private lateinit var binding: FragmentHasilLatihanBinding
    private lateinit var scoreViewModel : ScoreViewModel
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHasilLatihanBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val hasilBenar = this.arguments!!.getInt("jumlahBenar")
        val hasilSalah = this.arguments!!.getInt("jumlahSalah")
        val subJudul = this.arguments!!.getString("subtitle")
        val title = this.arguments!!.getString("title")
        Log.i("info", "$subJudul")
        binding.nilaiBenar.text = hasilBenar.toString()
        binding.nilaiSalah.text = hasilSalah.toString()
        binding.btnLanjutkan.setOnClickListener {
            if (subJudul == "Huruf Hijaiyah"){
                postScoreHijaiyah()
                val bundle = Bundle()
                bundle.putString("judulLatihan", title)
                Log.i("score", "${postScoreHijaiyah()}")
                findNavController().navigate(R.id.action_fragmentHasilLatihan_to_fragmentDetailLatihanHuruf,bundle)
            }else if (subJudul == "Huruf Berharakat Kasrah"){
                postScoreKasrah()
                val bundle = Bundle()
                bundle.putString("judulLatihan", title)
                findNavController().navigate(R.id.action_fragmentHasilLatihan_to_fragmentDetailLatihanHuruf,bundle)
            }else if (subJudul == "Huruf Berharakat Dhammah"){
                postScoreDhammah()
                val bundle = Bundle()
                bundle.putString("judulLatihan", title)
                Log.i("score", "${postScoreDhammah()}")
                findNavController().navigate(R.id.action_fragmentHasilLatihan_to_fragmentDetailLatihanHuruf,bundle)
            }else if(subJudul == "Huruf Berharakat Fathah"){
                postScoreFathah()
                val bundle = Bundle()
                bundle.putString("judulLatihan", title)
                Log.i("score", "${postScoreFathah()}")
                findNavController().navigate(R.id.action_fragmentHasilLatihan_to_fragmentDetailLatihanHuruf, bundle)
            }

        }
    }
    private fun postScoreHijaiyah() {
        val id = sharedPreferences.getString("id", "")
        val hasilBenar = this.arguments!!.getInt("jumlahBenar") * 10
        scoreViewModel.patchScoreHijaiyahImage(id!!, hasilBenar)
    }

    private fun postScoreFathah(){
        val id = sharedPreferences.getString("id", "")
        val hasilBenar = this.arguments!!.getInt("jumlahBenar") * 10
        scoreViewModel.patchScoreFathahImage(id!!, hasilBenar)
    }

    private fun postScoreKasrah(){
        val id = sharedPreferences.getString("id", "")
        val hasilBenar = this.arguments!!.getInt("jumlahBenar") * 10
        scoreViewModel.patchScoreKasrahImage(id!!, hasilBenar)
    }
    private fun postScoreDhammah(){
        val id = sharedPreferences.getString("id", "")
        val hasilBenar = this.arguments!!.getInt("jumlahBenar") * 10
        scoreViewModel.patchScoreDhammahImage(id!!, hasilBenar)
    }
}