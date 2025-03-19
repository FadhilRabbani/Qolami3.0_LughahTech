package com.test.qolami.view.splashandomboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.test.qolami.R
import com.test.qolami.databinding.FragmentOnBoardingMangerBinding
import com.test.qolami.view.adapter.OnBoardingPagerAdapter
import com.test.qolami.view.splashandomboarding.data.page
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingMangerFragment : Fragment() {
    private val pagerList = arrayListOf(
        page(R.drawable.logo_qolami,"QOLAMI","Menggunakan Metode!", R.drawable.bg_onboarding1),
        page(R.drawable.logo_qolami,"QOLAMI","Mengajarkanmu!", R.drawable.qolami_maskot),
        page(R.drawable.logo_qolami,"QOLAMI","Dari Mana Saja!", R.drawable.bg_onboarding3)
    )
    private val onBoardingChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
        }
    }
    lateinit var binding: FragmentOnBoardingMangerBinding
    lateinit var onBoardingViewPager2 : ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
         binding = FragmentOnBoardingMangerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoardingViewPager2 = binding.viewPager
        onBoardingViewPager2.apply {
            adapter =  OnBoardingPagerAdapter(this@OnBoardingMangerFragment, pagerList)
            registerOnPageChangeCallback(onBoardingChangeCallback)
            (getChildAt(0)as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, onBoardingViewPager2){tab, position  ->}.attach()

        binding.btnNext.setOnClickListener {
            if (onBoardingViewPager2.currentItem < onBoardingViewPager2.adapter!!.itemCount -1) {
                onBoardingViewPager2.currentItem += 1
            }else{
                finishedOnboarding()
                findNavController().navigate(R.id.action_onBoardingMangerFragment_to_homeFragment)
            }
        }
        binding.txtMasuk.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingMangerFragment_to_loginFragment)
        }
    }
    private fun finishedOnboarding(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }



}