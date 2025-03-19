package com.test.qolami.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.test.qolami.view.splashandomboarding.OnBoarding1Fragment
import com.test.qolami.view.splashandomboarding.OnBoardingMangerFragment
import com.test.qolami.view.splashandomboarding.data.page

class OnBoardingPagerAdapter(fragmentActivity: OnBoardingMangerFragment, private val pagerList: ArrayList<page>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return pagerList.size
    }


    override fun createFragment(position: Int): Fragment {
        return OnBoarding1Fragment(pagerList[position])

    }
}