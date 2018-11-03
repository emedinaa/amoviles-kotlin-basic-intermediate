package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intents.*

class AActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        button.setOnClickListener {
            goToBView()
        }
    }

    private fun goToBView(){
        val bundle= Bundle()
        bundle.putString("NAME","Eduardo Medina")
        bundle.putString("MESSAGE","Hello Kotlin from A view")
        bundle.putInt("AGE",18)
        bundle.putString("MESSAGE","Hello Kotlin from A view")
        val intent= Intent(this, BActivity::class.java)
        startActivity(intent)
    }
}


