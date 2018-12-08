package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        ui()
    }


    private fun ui(){
        btnNext.setOnClickListener {
            goToMain()
        }

        llaySignUp.setOnClickListener {
            goToSignUp()
        }
    }


    private fun goToMain(){
        val bundle:Bundle= Bundle().apply {
            putString("USERNAME","emedinaaa")
            putInt("USERID",100)
            putBoolean("STATE",false)
        }
        val intent= Intent(this, MainActivity::class.java)
        intent.putExtras(bundle)

        startActivity(intent)
    }

    private fun goToSignUp(){
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
