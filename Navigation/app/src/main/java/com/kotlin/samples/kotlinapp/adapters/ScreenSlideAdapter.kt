package com.kotlin.samples.kotlinapp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kotlin.samples.kotlinapp.fragments.ScreenSlideFragment

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */

class ScreenSlideAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        /**
         * The number of pages (wizard steps) to show in this demo.
         */
        const val NUM_PAGES=5
    }

    override fun getItem(p0: Int): Fragment {
        return ScreenSlideFragment()
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }
}