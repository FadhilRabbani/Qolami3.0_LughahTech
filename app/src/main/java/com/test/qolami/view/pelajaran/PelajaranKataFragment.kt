package com.test.qolami.view.pelajaran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.qolami.R
import com.test.qolami.databinding.FragmentPelajaranHurufBinding
import com.test.qolami.databinding.FragmentPelajaranKataBinding
import com.test.qolami.view.adapter.pelajaran.PelajaranHurufAdapter
import com.test.qolami.view.adapter.pelajaran.PelajaranKataAdapter
import com.test.qolami.view.pelajaran.data.DataPelajaranHuruf
import com.test.qolami.view.pelajaran.data.DataPelajaranKata
import com.test.qolami.viewnodel.PelajaranHurufViewModel
import com.test.qolami.viewnodel.PelajaranKataViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class PelajaranKataFragment : Fragment() {
    private lateinit var binding: FragmentPelajaranKataBinding
    private lateinit var pelajaranKataViewModel: PelajaranKataViewModel
    private lateinit var pelajaranKataAdapter: PelajaranKataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentPelajaranKataBinding.inflate(layoutInflater, container, false)
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
        pelajaranKataViewModel = ViewModelProvider(this).get(PelajaranKataViewModel::class.java)
        pelajaranKataAdapter = PelajaranKataAdapter(ArrayList())
        pelajaranKataViewModel.getData()
        binding.rcCon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcCon.adapter = pelajaranKataAdapter
        pelajaranKataViewModel.getDataKata.observe(viewLifecycleOwner) {
            pelajaranKataAdapter.dataKata = it as ArrayList<DataPelajaranKata>
            pelajaranKataAdapter.notifyDataSetChanged()
        }
    }
}