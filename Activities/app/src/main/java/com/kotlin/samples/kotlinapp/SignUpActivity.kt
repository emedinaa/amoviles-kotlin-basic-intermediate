package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        ui()
    }

    private fun ui(){
        btnNext.setOnClickListener {
            goToMain()
        }

        /*iviBack.setOnClickListener {
            goToLogIn()
        }*/
    }

    private fun goToMain(){
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun goToLogIn(){
        //startActivity(Intent(this, LogInActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
