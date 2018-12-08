package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.kotlin.samples.kotlinapp.fragments.FragmentS1

class FS1Activity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private var  fragmentS1:FragmentS1?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fs1)
        fragmentManager= supportFragmentManager

        if(fragmentManager.findFragmentById(R.id.fragment) is FragmentS1){
            fragmentS1= fragmentManager.findFragmentById(R.id.fragment) as FragmentS1
        }

        fragmentS1?.changeColor("#AED581")
        //fragmentS1?.changeColor("#FFCA28")

    }
}
