package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.kotlin.samples.kotlinapp.fragments.FragmentS2
import kotlinx.android.synthetic.main.activity_fs2.*

class FS2Activity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private val fragmentS2:FragmentS2=FragmentS2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fs2)

        fragmentManager= supportFragmentManager
        if(savedInstanceState==null){
            addFragment()
        }
        button.setOnClickListener {
            fragmentS2.changeText("Hello FragmentS2!")
        }
        //fragmentS2.changeText("Hello FragmentS2!")
    }

    private fun addFragment(){
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.apply {
            //add(R.id.frameLayout,fragmentS2) //No view found
            add(R.id.container,fragmentS2)
            commit()
        }
    }
}
