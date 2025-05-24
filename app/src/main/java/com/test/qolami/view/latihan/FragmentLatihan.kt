package com.test.qolami.view.latihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentLatihanBinding
import com.test.qolami.view.home.PopUpFiturSedangDikembankanFragment
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class FragmentLatihan : Fragment() {
    private lateinit var binding : FragmentLatihanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLatihanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHuruf.setOnClickListener {
        findNavController().navigate(R.id.action_fragmentLatihan_to_fragmentLatihanHuruf)
        }
        binding.btnKata.setOnClickListener {
            val popUpFiturFragment = PopUpFiturSedangDikembankanFragment()
            popUpFiturFragment.show(childFragmentManager, "popupfitur")
        }
        binding.btnRangkaian.setOnClickListener {
            val popUpFiturFragment = PopUpFiturSedangDikembankanFragment()
            popUpFiturFragment.show(childFragmentManager, "popupfitur")
        }
    }


}