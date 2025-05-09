package com.test.qolami.view.pelajaran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.test.qolami.databinding.FragmentPelajaran1Binding
import com.test.qolami.view.adapter.pelajaran.PelajaranHuruf1Adapter
import com.test.qolami.view.adapter.pelajaran.PelajaranHuruf2Adapter
import com.test.qolami.view.adapter.pelajaran.PelajaranHuruf3Adapter
import com.test.qolami.view.adapter.pelajaran.PelajaranHuruf4Adapter
import com.test.qolami.view.adapter.pelajaran.PelajaranHuruf5Adapter
import com.test.qolami.view.adapter.pelajaran.PelajaranHuruf6Adapter
import com.test.qolami.view.adapter.pelajaran.PelajaranHuruf7Adapter
import com.test.qolami.view.pelajaran.data.DataAudioHijaiyaj
import com.test.qolami.view.pelajaran.data.DataMenuPelajaran1Huruf
import com.test.qolami.viewnodel.PelajaranHurufViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Pelajaran1Fragment : Fragment() {
    private lateinit var binding: FragmentPelajaran1Binding
    private lateinit var pelajaranHurufViewModel:PelajaranHurufViewModel
    private lateinit var pelajaranHuruf1Adapter: PelajaranHuruf1Adapter
    private lateinit var pelajaranHuruf2Adapter: PelajaranHuruf2Adapter
    private lateinit var pelajaranHuruf3Adapter: PelajaranHuruf3Adapter
    private lateinit var pelajaranHuruf4Adapter: PelajaranHuruf4Adapter
    private lateinit var pelajaranHuruf5Adapter: PelajaranHuruf5Adapter
    private lateinit var pelajaranHuruf6Adapter: PelajaranHuruf6Adapter
    private lateinit var pelajaranHuruf7Adapter: PelajaranHuruf7Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPelajaran1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageBack.setOnClickListener {
            findNavController().navigateUp()
        }
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        val getDataPelajaran = this.arguments?.getString("pelajaranAtas")
        val getDataJudulPelajaran = this.arguments?.getString("judul")
        binding.textPelajaran.text = getDataPelajaran.toString()
        binding.textJudul.text = getDataJudulPelajaran.toString()
        when (binding.textPelajaran.text.toString()) {
            "Pelajaran 1" -> {
                return rcLayoutHurufPelajaran1()
            }
            "Pelajaran 2" -> {
                return rcLayoutHurufPelajaran2()
            }
            "Pelajaran 3" -> {
                return rcLayoutHurufPelajaran3()
            }
            "Pelajaran 4" -> {
                return rcLayoutHurufPelajaran4()
            }
            "Pelajaran 5" -> {
                return rcLayoutHurufPelajaran5()
            }
            "Pelajaran 6" -> {
                return rcLayoutHurufPelajaran6()
            }
            "Pelajaran 7" -> {
                return rcLayoutHurufPelajaran7()
            }
        }
    }

    private fun rcLayoutHurufPelajaran1(){
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        pelajaranHuruf1Adapter = PelajaranHuruf1Adapter(ArrayList())
        pelajaranHurufViewModel.getAudioPelajaran1()
        binding.rcCon.layoutManager = GridLayoutManager(context, 5)
        binding.rcCon.adapter = pelajaranHuruf1Adapter
        pelajaranHurufViewModel.getDataAudPelajaran1.observe(viewLifecycleOwner) {
            pelajaranHuruf1Adapter.listHurufHijaiyah = it as ArrayList<DataAudioHijaiyaj>
        }
    }
    private fun rcLayoutHurufPelajaran2(){
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        pelajaranHuruf2Adapter = PelajaranHuruf2Adapter(ArrayList())
        pelajaranHurufViewModel.getPelajaran2()
        binding.rcCon.layoutManager = GridLayoutManager(context, 5)
        binding.rcCon.adapter = pelajaranHuruf2Adapter
        pelajaranHurufViewModel.getDataPelajaran2.observe(viewLifecycleOwner){
            pelajaranHuruf2Adapter.listHurufFathah = it as ArrayList<DataMenuPelajaran1Huruf>
        }
    }
    private fun rcLayoutHurufPelajaran3(){
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        pelajaranHuruf3Adapter = PelajaranHuruf3Adapter(ArrayList())
        pelajaranHurufViewModel.getPelajaran3()
        binding.rcCon.layoutManager = GridLayoutManager(context, 5)
        binding.rcCon.adapter = pelajaranHuruf3Adapter
        pelajaranHurufViewModel.getDataPelajaran3.observe(viewLifecycleOwner){
            pelajaranHuruf3Adapter.listHurufKasrah = it as ArrayList<DataMenuPelajaran1Huruf>
        }
    }
    private fun rcLayoutHurufPelajaran4(){
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        pelajaranHuruf4Adapter = PelajaranHuruf4Adapter(ArrayList())
        pelajaranHurufViewModel.getPelajaran4()
        binding.rcCon.layoutManager = GridLayoutManager(context, 5)
        binding.rcCon.adapter = pelajaranHuruf4Adapter
        pelajaranHurufViewModel.getDataPelajaran4.observe(viewLifecycleOwner){
            pelajaranHuruf4Adapter.listHurufDhammah = it as ArrayList<DataMenuPelajaran1Huruf>
        }
    }
    private fun rcLayoutHurufPelajaran5(){
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        pelajaranHuruf5Adapter = PelajaranHuruf5Adapter(ArrayList())
        pelajaranHurufViewModel.getPelajaran5()
        binding.rcCon.layoutManager = GridLayoutManager(context, 5)
        binding.rcCon.adapter = pelajaranHuruf5Adapter
        pelajaranHurufViewModel.getDataPelajaran5.observe(viewLifecycleOwner){
            pelajaranHuruf5Adapter.listHurufFathahain = it as ArrayList<DataMenuPelajaran1Huruf>
        }
    }
    private fun rcLayoutHurufPelajaran6(){
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        pelajaranHuruf6Adapter = PelajaranHuruf6Adapter(ArrayList())
        pelajaranHurufViewModel.getPelajaran6()
        binding.rcCon.layoutManager = GridLayoutManager(context, 5)
        binding.rcCon.adapter = pelajaranHuruf6Adapter
        pelajaranHurufViewModel.getDataPelajaran6.observe(viewLifecycleOwner){
            pelajaranHuruf6Adapter.listHurufKasrahtain = it as ArrayList<DataMenuPelajaran1Huruf>
        }
    }
    private fun rcLayoutHurufPelajaran7(){
        pelajaranHurufViewModel = ViewModelProvider(this)[PelajaranHurufViewModel::class.java]
        pelajaranHuruf7Adapter = PelajaranHuruf7Adapter(ArrayList())
        pelajaranHurufViewModel.getPelajaran7()
        binding.rcCon.layoutManager = GridLayoutManager(context, 5)
        binding.rcCon.adapter = pelajaranHuruf7Adapter
        pelajaranHurufViewModel.getDataPelajaran7.observe(viewLifecycleOwner){
            pelajaranHuruf7Adapter.listHurufDammahtain = it as ArrayList<DataMenuPelajaran1Huruf>
        }
    }


}