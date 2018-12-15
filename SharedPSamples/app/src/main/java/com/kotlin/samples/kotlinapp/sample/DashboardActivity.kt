package com.kotlin.samples.kotlinapp.sample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.sample.PreferencesHelper.clearSession
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnLogOut.setOnClickListener {
            //borrar sesión
            //ir al login
            //destruir activity
            clearSession()
            goToLogIn()
            finish()
        }
    }

    private fun goToLogIn(){
        val intent= Intent(this,LogInActivity::class.java)
        startActivity(intent)
    }


    private fun clearSession(){
        PreferencesHelper.clearSession(this)
    }
}
