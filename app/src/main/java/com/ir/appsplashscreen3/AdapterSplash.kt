package com.ir.appsplashscreen3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ir.appsplashscreen3.DataClassSplash.DataClassSplash

class AdapterSplash(
    var arrayListSplash: ArrayList<DataClassSplash>,
    var fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return arrayListSplash.size
    }

    override fun createFragment(position: Int): Fragment {
        return MyItemFragment.newInstance(arrayListSplash[position].stringName , arrayListSplash[position].stringDescription , arrayListSplash[position].image.toString() , position.toString())
    }
}