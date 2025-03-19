package com.test.qolami.view.pelajaran

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentPelajaranBinding
import com.test.qolami.view.home.PopUpFiturSedangDikembankanFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PelajaranFragment : Fragment() {
    private lateinit var binding :FragmentPelajaranBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPelajaranBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHuruf.setOnClickListener {
            findNavController().navigate(R.id.action_pelajaranFragment_to_pelajaranHurufFragment)
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