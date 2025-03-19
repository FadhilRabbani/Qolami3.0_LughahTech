package com.test.qolami.view.latihan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentSoalLatihanImageBinding
import com.test.qolami.viewnodel.LatihanHurufViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class FragmentSoalLatihanImage : Fragment() {
    private lateinit var binding : FragmentSoalLatihanImageBinding
    private lateinit var latihanHurufViewModel: LatihanHurufViewModel
    private lateinit var sharedPreferences: SharedPreferences
    var indexYangDipilih: Int = 0
    var indexTerkini: Int = 1
    var jumlahBenar = 0
    var jumlahSalah = 0
    var subtitle = ""
    var title = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSoalLatihanImageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backImg.setOnClickListener {
            findNavController().navigateUp()
        }
        Log.i("Index yang di pilih", "$indexYangDipilih")
        sharedPreferences = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        val textJudul = sharedPreferences.getString("latihan", "")
        latihanHurufViewModel = ViewModelProvider(this).get(LatihanHurufViewModel::class.java)
        Log.i("info", "$textJudul")
        binding.textPelajaran.text = textJudul
        when(binding.textPelajaran.text){
            "Latihan 1" ->
                setSoal1()
            "Latihan 2" ->
                setSoal2()
            "Latihan 3" ->
                setSoal3()
            "Latihan 4" ->
                setSoal4()
        }
        binding.option1.setOnClickListener {
            selectedOption(binding.txtJawaban1, binding.option1, 1)
        }
        binding.option2.setOnClickListener {
            selectedOption(binding.txtJawaban2, binding.option2, 2)

        }
        binding.option3.setOnClickListener {
            selectedOption(binding.txtJawaban3, binding.option3,3)

        }
        binding.option4.setOnClickListener {
            selectedOption(binding.txtJawaban4, binding.option4,4)

        }
        binding.buttonCheckSoal.setOnClickListener {
            if (checkJawaban() == true){
                jumlahBenar++
                Log.e("info", "$jumlahBenar")
            }else{
                jumlahSalah++
                Log.e("info", "$jumlahSalah")
            }
            Log.i("Index yang di pilih", "$indexYangDipilih")
            showBottomSheetDialog()
        }
    }

    private fun setSoal1(){
        latihanHurufViewModel.getSoal()
        latihanHurufViewModel.dataSoalImage.observe(viewLifecycleOwner){
                subtitle = it.latihanHijaiyah[indexTerkini - 1].subtitle
                title = it.latihanHijaiyah[indexTerkini  - 1].title
                binding.textJudul.text = it.latihanHijaiyah[indexTerkini - 1].subtitle
                binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
                binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
                binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
                binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
                binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]

        }
        defaultStyle()
    }
    private fun setSoal2(){
        latihanHurufViewModel.getSoalFathah()
        latihanHurufViewModel.dataSoalImageFathah.observe(viewLifecycleOwner){
            subtitle = it.latihanHijaiyah[indexTerkini - 1].subtitle
            title = it.latihanHijaiyah[indexTerkini  - 1].title
            binding.textJudul.text = it.latihanHijaiyah[indexTerkini - 1].subtitle
            binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
            binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
            binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
            binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
            binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]

        }
        defaultStyle()
    }
    private fun setSoal3(){
        latihanHurufViewModel.getSoalKasrah()
        latihanHurufViewModel.dataSoalImageKasrah.observe(viewLifecycleOwner){
            subtitle = it.latihanHijaiyah[indexTerkini - 1].subtitle
            title = it.latihanHijaiyah[indexTerkini  - 1].title
            binding.textJudul.text = it.latihanHijaiyah[indexTerkini - 1].subtitle
            binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
            binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
            binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
            binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
            binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]

        }
        defaultStyle()
    }
    private fun setSoal4(){
        latihanHurufViewModel.getSoalDhammah()
        latihanHurufViewModel.dataSoalImageDhammah.observe(viewLifecycleOwner){
            subtitle = it.latihanHijaiyah[indexTerkini - 1].subtitle
            title = it.latihanHijaiyah[indexTerkini  - 1].title
            binding.textJudul.text = it.latihanHijaiyah[indexTerkini - 1].subtitle
            binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
            binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
            binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
            binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
            binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]

        }
        defaultStyle()
    }


    fun checkJawaban():Boolean{
        var indikator  = false
        if(binding.textPelajaran.text == "Latihan 1"){
            latihanHurufViewModel = ViewModelProvider(this).get(LatihanHurufViewModel::class.java)
            latihanHurufViewModel.dataSoalImage.observe(viewLifecycleOwner) {
                if (indexYangDipilih - 1 == it.latihanHijaiyah[indexTerkini.minus(1)].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 2"){
            latihanHurufViewModel = ViewModelProvider(this).get(LatihanHurufViewModel::class.java)
            latihanHurufViewModel.dataSoalImageFathah.observe(viewLifecycleOwner) {
                if (indexYangDipilih - 1 == it.latihanHijaiyah[indexTerkini.minus(1)].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 3"){
            latihanHurufViewModel = ViewModelProvider(this).get(LatihanHurufViewModel::class.java)
            latihanHurufViewModel.dataSoalImageKasrah.observe(viewLifecycleOwner) {
                if (indexYangDipilih - 1 == it.latihanHijaiyah[indexTerkini.minus(1)].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 4"){
            latihanHurufViewModel = ViewModelProvider(this).get(LatihanHurufViewModel::class.java)
            latihanHurufViewModel.dataSoalImageDhammah.observe(viewLifecycleOwner) {
                if (indexYangDipilih - 1 == it.latihanHijaiyah[indexTerkini.minus(1)].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }
        return  indikator
    }
    fun lanjutkanSoal(){
        indexTerkini ++
        indexYangDipilih = 0
        if (checkSoalSelesai() == true){
            if (binding.textPelajaran.text == "Latihan 1"){
                latihanHurufViewModel.dataSoalImage.observe(viewLifecycleOwner) {
                    binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
                    binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]
                }
            }else if (binding.textPelajaran.text == "Latihan 2"){
                latihanHurufViewModel.dataSoalImageFathah.observe(viewLifecycleOwner) {
                    binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
                    binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]
                }
            }else if (binding.textPelajaran.text == "Latihan 3"){
                latihanHurufViewModel.dataSoalImageKasrah.observe(viewLifecycleOwner) {
                    binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
                    binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]
                }
            }else if (binding.textPelajaran.text == "Latihan 4"){
                latihanHurufViewModel.dataSoalImageDhammah.observe(viewLifecycleOwner) {
                    binding.txtSoal.text = it.latihanHijaiyah[indexTerkini - 1].question
                    binding.txtJawaban1.text = it.latihanHijaiyah[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanHijaiyah[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanHijaiyah[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanHijaiyah[indexTerkini - 1].options[3]
                }
            }
            defaultStyle()
        }

    }

    private fun checkSoalSelesai():Boolean{
        var indikatorSoal = false
        val bundle = Bundle()
        bundle.putInt("jumlahBenar", jumlahBenar)
        bundle.putInt("jumlahSalah", jumlahSalah)
        bundle.putString("subtitle", subtitle)
        bundle.putString("title", title)
        if(binding.textPelajaran.text == "Latihan 1") {
            latihanHurufViewModel.dataSoalImage.observe(viewLifecycleOwner) {
//                bundle.putString("subJudul", it.latihanHijaiyah[indexTerkini - 1].subtitle)
                if (indexTerkini > it.latihanHijaiyah.size) {
                    indikatorSoal = false
                    findNavController().navigate(R.id.action_fragmentSoalLatihanImage_to_fragmentHasilLatihan, bundle)
                } else {
                    indikatorSoal = true
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 2"){
            latihanHurufViewModel.dataSoalImageFathah.observe(viewLifecycleOwner) {
                if (indexTerkini > it.latihanHijaiyah.size) {
                    indikatorSoal = false
                    findNavController().navigate(R.id.action_fragmentSoalLatihanImage_to_fragmentHasilLatihan,bundle)
                } else {
                    indikatorSoal = true
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 3"){
            latihanHurufViewModel.dataSoalImageKasrah.observe(viewLifecycleOwner) {
                if (indexTerkini > it.latihanHijaiyah.size) {
                    indikatorSoal = false
                    findNavController().navigate(R.id.action_fragmentSoalLatihanImage_to_fragmentHasilLatihan, bundle)
                } else {
                    indikatorSoal = true
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 4"){
            latihanHurufViewModel.dataSoalImageDhammah.observe(viewLifecycleOwner) {
                if (indexTerkini > it.latihanHijaiyah.size) {
                    indikatorSoal = false
                    findNavController().navigate(R.id.action_fragmentSoalLatihanImage_to_fragmentHasilLatihan, bundle)
                } else {
                    indikatorSoal = true
                }
            }
        }
        return indikatorSoal
    }
    private fun showBottomSheetDialog() {
        val bottomSheetDialogFragment = DialogFragmentJawaban()
        bottomSheetDialogFragment.isCancelable = false
        bottomSheetDialogFragment.show(childFragmentManager, bottomSheetDialogFragment.tag)
    }
    private fun defaultStyle(){
        val optionsText = ArrayList<TextView>()
        optionsText.add(0, binding.txtJawaban1)
        optionsText.add(1, binding.txtJawaban2)
        optionsText.add(2, binding.txtJawaban3)
        optionsText.add(3, binding.txtJawaban4)
        for (option in optionsText){
            option.setTextColor(resources.getColor(R.color.black))
        }
        val optionsCv = ArrayList<CardView>()
        optionsCv.add(0, binding.option1)
        optionsCv.add(1, binding.option2)
        optionsCv.add(2, binding.option3)
        optionsCv.add(3, binding.option4)
        for (optionCv in optionsCv){
            optionCv.setCardBackgroundColor(resources.getColor(R.color.white))
        }
    }
    private fun selectedOption(tv:TextView, cv:CardView, indexOption: Int){
        defaultStyle()
        indexYangDipilih = indexOption
        tv.setTextColor(resources.getColor(R.color.white))
        cv.setCardBackgroundColor(resources.getColor(R.color.warna_hijau_muda))
    }




}