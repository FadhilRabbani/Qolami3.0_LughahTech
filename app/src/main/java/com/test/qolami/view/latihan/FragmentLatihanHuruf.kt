package com.test.qolami.view.latihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.qolami.R
import com.test.qolami.databinding.FragmentLatihanHurufBinding
import com.test.qolami.view.adapter.latihan.LatihanHurufAdapter

import com.test.qolami.viewnodel.LatihanHurufViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class FragmentLatihanHuruf : Fragment() {
    private lateinit var binding : FragmentLatihanHurufBinding
    private lateinit var latihanHurufViewModel: LatihanHurufViewModel
    private lateinit var latihanHurufAdapter: LatihanHurufAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLatihanHurufBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLatihanHuruf_to_fragmentLatihan)
        }
        layoutData()
    }
    fun layoutData(){
        latihanHurufViewModel = ViewModelProvider(this).get(LatihanHurufViewModel::class.java)
        latihanHurufAdapter = LatihanHurufAdapter(ArrayList())
        latihanHurufViewModel.getData()
        binding.rcCon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcCon.adapter = latihanHurufAdapter
        latihanHurufViewModel.getDataHuruf.observe(viewLifecycleOwner) {
            latihanHurufAdapter.dataHuruf = it as ArrayList<DataLatihanHuruf>
            latihanHurufAdapter.notifyDataSetChanged()
        }
    }


}