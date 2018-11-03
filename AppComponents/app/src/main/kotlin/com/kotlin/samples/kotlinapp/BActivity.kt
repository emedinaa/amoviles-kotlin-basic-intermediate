package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : AppCompatActivity() {

    private var message:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        verifyExtras()

        //events
        button.setOnClickListener {
            //finish
        }

        populate()
    }

    private fun populate(){
        textView.text= message
    }

    private fun verifyExtras(){
        //(intent?.extras?.containsKey("MESSAGE"))
        //val bundle= intent?.extras
        intent?.extras?.let {
            if(intent.extras.containsKey("MESSAGE")){
                message= intent?.extras?.getString("MESSAGE")
            }
        }

        log(message)
    }
    private fun log(value:String?){
        Log.v("CONSOLE","value $value")
    }
}
