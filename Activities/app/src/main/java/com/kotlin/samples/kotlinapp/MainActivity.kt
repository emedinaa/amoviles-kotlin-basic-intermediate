package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userName:String ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        verifyExtras()
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //populate()
    }


    private fun populate(){
        textView.text= "Welcome $userName !"
    }

    private fun verifyExtras(){
        intent?.extras?.let {
            if(it.containsKey("USERNAME")){
                userName= it.getString("USERNAME")
            }
        }
    }

    /*override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }*/
}
