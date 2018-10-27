package com.emedinaa.myapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO ESCRIBIR CODIGO
        textView.setOnClickListener {
            //action
            showMessage()
        }
    }

    fun showMessage(){
        Toast.makeText(this,"Hola Kotlin! "
                ,Toast.LENGTH_LONG).show()
    }
}
