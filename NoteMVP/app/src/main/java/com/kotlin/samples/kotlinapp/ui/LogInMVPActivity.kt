package com.kotlin.samples.kotlinapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlin.samples.kotlinapp.R
import kotlinx.android.synthetic.main.layout_loading.*
import android.R.attr.password
import android.content.Intent
import com.kotlin.samples.kotlinapp.storage.*
import kotlinx.android.synthetic.main.activity_log_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.presenters.LogInPresenter
import com.kotlin.samples.kotlinapp.storage.PreferencesHelper.saveSession
import com.kotlin.samples.kotlinapp.ui.view.LogInView


class LogInMVPActivity : AppCompatActivity(), LogInView {

    private lateinit var presenter:LogInPresenter
    private var username: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        presenter= LogInPresenter(this)
        //eventos
        btnLogin.setOnClickListener {
            if(validateForm()){
                presenter.logIn(username,password)
            }
        }
    }

    override fun saveSession(logInResponse: LogInResponse?){
        logInResponse?.let {
            if(it.email!=null && it.token!=null){
                PreferencesHelper.saveSession(this,it.email,it.token)
            }
        }
    }

    //acciones de la vista
    private fun validateForm(): Boolean {
        username = eteUsername.text.toString()
        password = etePassword.text.toString()

        if (username.isNullOrEmpty()) {
            eteUsername.error="Error campo username"
            return false
        }
        if (password.isNullOrEmpty()) {
            etePassword.error="Error campo password"
            return false
        }
        return true
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this@LogInMVPActivity,
                "LogIn $message", Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {
        flayLoading.visibility= View.GONE
    }

    override fun showLoading() {
        flayLoading.visibility= View.VISIBLE
    }

    override fun goToNoteList() {
        val intent= Intent(this,NoteListActivity::class.java)
        startActivity(intent)
    }

}
