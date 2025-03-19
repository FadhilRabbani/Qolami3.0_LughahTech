package com.test.qolami.view.pelajaran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.qolami.databinding.FragmentPelajaranHurufBinding
import com.test.qolami.view.adapter.pelajaran.PelajaranHurufAdapter
import com.test.qolami.view.pelajaran.data.DataPelajaranHuruf
import com.test.qolami.viewnodel.PelajaranHurufViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PelajaranHurufFragment : Fragment() {
    private lateinit var binding: FragmentPelajaranHurufBinding
    private lateinit var pelajaranHurufViewModel: PelajaranHurufViewModel
    private lateinit var pelajaranHurufAdapter: PelajaranHurufAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentPelajaranHurufBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageBack.setOnClickListener {
            findNavController().navigateUp()
        }
        layoutData()

    }
    fun layoutData(){
        pelajaranHurufViewModel = ViewModelProvider(this).get(PelajaranHurufViewModel::class.java)
        pelajaranHurufAdapter = PelajaranHurufAdapter(ArrayList())
        pelajaranHurufViewModel.getData()
        binding.rcCon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcCon.adapter = pelajaranHurufAdapter
        pelajaranHurufViewModel.getDataHuruf.observe(viewLifecycleOwner) {
            pelajaranHurufAdapter.dataHuruf = it as ArrayList<DataPelajaranHuruf>
            pelajaranHurufAdapter.notifyDataSetChanged()
        }
    }

}