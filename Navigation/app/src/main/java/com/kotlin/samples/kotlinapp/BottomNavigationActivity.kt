package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.fragments.AFragment
import com.kotlin.samples.kotlinapp.fragments.BFragment
import com.kotlin.samples.kotlinapp.fragments.CFragment

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bottomNavigationView.setOnNavigationItemSelectedListener {

            var fragment:Fragment?=null

            when(it.itemId){
                R.id.action_favorites -> fragment=AFragment.newInstance("","")
                R.id.action_schedules -> fragment=BFragment.newInstance("","")
                R.id.action_music -> fragment=CFragment.newInstance("","")
            }

            fragment?.let {
                changeFragment(it)
            }
            return@setOnNavigationItemSelectedListener true
        }

        //first tab
        changeFragment(AFragment.newInstance("",""))
    }


    private fun changeFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment,null)
            commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
