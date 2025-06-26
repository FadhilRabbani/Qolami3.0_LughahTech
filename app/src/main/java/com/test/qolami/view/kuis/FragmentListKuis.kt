package com.test.qolami.view.kuis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.qolami.R
import com.test.qolami.databinding.FragmentListKuisBinding
import com.test.qolami.view.adapter.kuis.KuisAdapter
import com.test.qolami.viewnodel.KuisViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentListKuis : Fragment() {
    private lateinit var binding: FragmentListKuisBinding
    private lateinit var kuisViewModel: KuisViewModel
    private lateinit var kuisAdapter: KuisAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kuisViewModel = ViewModelProvider(this)[KuisViewModel::class.java]
        kuisAdapter = KuisAdapter(emptyList())

        binding.rcKuis.layoutManager = LinearLayoutManager(requireContext())
        binding.rcKuis.adapter = kuisAdapter

        kuisViewModel.fetchKuis()

        kuisViewModel.listKuis.observe(viewLifecycleOwner) {
            kuisAdapter.setData(it)
        }

        binding.imageBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
