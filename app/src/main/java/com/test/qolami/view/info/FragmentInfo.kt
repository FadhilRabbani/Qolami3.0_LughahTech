package com.test.qolami.view.info

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentInfoBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class FragmentInfo : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.ivTiktok.setOnClickListener{
            val ttLink = "https://www.tiktok.com/@metode_qolami?_t=8kmdKPWd0GC&_r=1"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ttLink))
            startActivity(intent)
        }
        binding.ivYoutube.setOnClickListener {
            val ytLink = "https://www.youtube.com/@qolamichanel9019"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ytLink))
            startActivity(intent)
        }
    }


}