package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //events
        btnClick.setOnClickListener {
            goToBasicEvents()
        }

        btnForm.setOnClickListener {
            goToForm()
        }

        btnItems.setOnClickListener {
            goToItemEvents()
        }

        btnKeyboard.setOnClickListener {
            goToKeyboardEvents()
        }

        //button.setOnClickListener {  }
    }

    private fun goToBasicEvents() {

        //1.Contexto de la vista donde te encuentras
        //2. Conocer la pantalla de destino
        startActivity(Intent(this, BasicEventsActivity::class.java))
    }

    private fun goToItemEvents() {
        startActivity(Intent(this, ItemEventsActivity::class.java))
    }

    private fun goToForm() {
        startActivity(Intent(this, FormActivity::class.java))
    }

    private fun goToKeyboardEvents() {
        startActivity(Intent(this, KeyboardEventsActivity::class.java))
    }
}
