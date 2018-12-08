package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    companion object {
        const val SPLASH_TIME:Long=3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer= Timer()

        timer.schedule(timerTask {
            goToLogIn()
        },SPLASH_TIME)
    }

    private fun goToLogIn(){
        //Pantalla inicial
        //Pantalla destino
        //startActivity
        //Necesito regresar?

        val intent= Intent(this,LogInActivity::class.java)
        startActivity(intent)
        finish()
        //startActivity(Intent(this, LogInActivity::class.java))
    }
}
