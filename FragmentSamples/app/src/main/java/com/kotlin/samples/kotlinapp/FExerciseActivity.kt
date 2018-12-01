package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.kotlin.samples.kotlinapp.fragments.BottomBarFragment
import com.kotlin.samples.kotlinapp.fragments.BoxFragment

class FExerciseActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private var  bottomBarFragment: BottomBarFragment?=null
    private var  boxFragment: BoxFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fexercise)

        fragmentManager = supportFragmentManager

        if (fragmentManager.findFragmentById(R.id.fragBottom) is BottomBarFragment) {
            bottomBarFragment= fragmentManager.findFragmentById(R.id.fragBottom) as BottomBarFragment
        }

        if (fragmentManager.findFragmentById(R.id.fragBox) is BoxFragment) {
            boxFragment= fragmentManager.findFragmentById(R.id.fragBox) as BoxFragment
        }
    }
}
