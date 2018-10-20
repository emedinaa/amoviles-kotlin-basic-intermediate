package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_empty.*

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        imageView.setOnClickListener {
            showMessage()
        }
    }

    private fun showMessage(){
        Toast.makeText(this, "Hello Kotlin!", Toast.LENGTH_LONG).show()
    }
}
