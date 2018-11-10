package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ui()

        //Linear Layout

        //setContentView(R.layout.activity_linear_vertical)
        //setContentView(R.layout.activity_linear_horizontal)

        //Linear Layout Weights

        //setContentView(R.layout.layout_weight_vertical)
        //setContentView(R.layout.layout_weight_horizontal)

        //Relative Layout

        //setContentView(R.layout.activity_relative)
        //setContentView(R.layout.layout_relative_transparent)

        //Constraint Layout

        //setContentView(R.layout.activity_contraint)

        //Samples

        //setContentView(R.layout.layout_linear_sample1)
        //setContentView(R.layout.layout_relative_sample1)
        //setContentView(R.layout.layout_relative_sample2)
        //setContentView(R.layout.layout_constraint_sample1)

        //setContentView(R.layout.layout_login_instagram_linear)
        //setContentView(R.layout.layout_login_instagram_relative)
        //setContentView(R.layout.layout_login_instragram_constraint)
    }

    private fun ui(){
        button.setOnClickListener {
            showMessage("Hello Kotlin!")
        }
    }

    private fun showMessage(message:String?){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        Log.v("CONSOLE","Log : $message")
    }
}
