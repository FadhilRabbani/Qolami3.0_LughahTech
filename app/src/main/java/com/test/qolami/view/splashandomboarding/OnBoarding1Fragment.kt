package com.test.qolami.view.splashandomboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.test.qolami.databinding.FragmentOnBoarding1Binding
import com.test.qolami.view.splashandomboarding.data.page
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class OnBoarding1Fragment(val page: page) : Fragment() {
    private lateinit var binding: FragmentOnBoarding1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoarding1Binding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logoqolami.setImageResource(page.logo)
        binding.textQolami.text = page.judul
        binding.textJelas.text = page.text
        binding.imageView3.setImageResource(page.maskot)
    }


}