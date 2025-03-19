package com.test.qolami.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.test.qolami.R
import com.test.qolami.databinding.FragmentPopUpFiturSedangDikembankanBinding


class PopUpFiturSedangDikembankanFragment : DialogFragment() {
    private lateinit var binding: FragmentPopUpFiturSedangDikembankanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPopUpFiturSedangDikembankanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            dismiss()
        }
    }


}