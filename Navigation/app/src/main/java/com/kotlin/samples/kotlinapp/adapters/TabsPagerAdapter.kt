package com.kotlin.samples.kotlinapp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.kotlin.samples.kotlinapp.fragments.AFragment
import com.kotlin.samples.kotlinapp.fragments.BFragment
import com.kotlin.samples.kotlinapp.fragments.CFragment

class TabsPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return AFragment.newInstance("","")
            1 -> return BFragment.newInstance("","")
            2 -> return CFragment.newInstance("","")
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Section ${position+1}"
    }
}