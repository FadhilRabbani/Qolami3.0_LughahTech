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
import com.test.qolami.databinding.FragmentLatihanKataBinding
import com.test.qolami.view.adapter.latihan.LatihanHurufAdapter
import com.test.qolami.view.adapter.latihan.LatihanKataAdapter
import com.test.qolami.viewnodel.LatihanHurufViewModel
import com.test.qolami.viewnodel.LatihanKataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLatihanKata : Fragment() {
    private lateinit var binding: FragmentLatihanKataBinding
    private lateinit var latihanKataViewModel: LatihanKataViewModel
    private lateinit var latihanKataAdapter: LatihanKataAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLatihanKataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLatihanKata_to_fragmentLatihan)
        }
        layoutData()
    }
    fun layoutData(){
        latihanKataViewModel = ViewModelProvider(this).get(LatihanKataViewModel::class.java)
        latihanKataAdapter = LatihanKataAdapter(ArrayList())
        latihanKataViewModel.getData()
        binding.rcCon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcCon.adapter = latihanKataAdapter
        latihanKataViewModel.getDataKata.observe(viewLifecycleOwner) {
            latihanKataAdapter.dataHuruf = it as ArrayList<DataLatihanKata>
            latihanKataAdapter.notifyDataSetChanged()
        }
    }
}