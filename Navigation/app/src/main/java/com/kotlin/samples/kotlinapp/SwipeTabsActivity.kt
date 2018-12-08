package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.adapters.TabsPagerAdapter
import kotlinx.android.synthetic.main.activity_swipe_tabs.*

class SwipeTabsActivity : AppCompatActivity() {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link android.support.v4.app.FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_tabs)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewPager()
        setupTabs()

        toolbar.setNavigationOnClickListener {
            //close()
        }
    }

    private fun setupViewPager(){
        viewPager.adapter= TabsPagerAdapter(supportFragmentManager)
    }

    private fun setupTabs(){
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun close(){
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
