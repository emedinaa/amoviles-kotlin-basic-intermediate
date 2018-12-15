package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.basic.SPActivity
import com.kotlin.samples.kotlinapp.sample.SplashActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ui()
    }

    private fun ui(){
        buttonBasic.setOnClickListener {
            startActivity(Intent(this,SPActivity::class.java))
        }

        buttonSample.setOnClickListener {
            startActivity(Intent(this,SplashActivity::class.java))
        }
    }
}
