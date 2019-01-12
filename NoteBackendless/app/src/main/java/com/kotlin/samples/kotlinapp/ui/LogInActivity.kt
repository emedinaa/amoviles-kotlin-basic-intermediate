package com.kotlin.samples.kotlinapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlin.samples.kotlinapp.R
import kotlinx.android.synthetic.main.layout_loading.*
import android.R.attr.password
import android.content.Intent
import android.util.Log
import com.kotlin.samples.kotlinapp.storage.*
import kotlinx.android.synthetic.main.activity_log_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.storage.PreferencesHelper.saveSession
import com.kotlin.samples.kotlinapp.utils.NLog


class LogInActivity : AppCompatActivity() {

    private var username: String? = null
    private var password: String? = null

    private var call: Call<LogInResponse>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        btnLogin.setOnClickListener {
            if(validateForm()){
                logIn()
            }
        }
    }

    private fun logIn(){
        showLoading()
        val logInRaw= LogInRaw(username,password)

        call= NoteApiClient.build()?.logInBL(NoteConstant.APPLICATIONID, NoteConstant.RESTAPIKEY,logInRaw)
        call?.enqueue(object : Callback<LogInResponse> {
            override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                hideLoading()
                showMessage(t.message)
            }

            override fun onResponse(call: Call<LogInResponse>, response: Response<LogInResponse>) {
                hideLoading()
                response?.body()?.let {
                    if(response.isSuccessful){
                        saveSession(response.body())
                        goToNoteList()
                    }else{
                        showMessage(response.errorBody()?.string())
                    }
                }
            }
        })
    }

    private fun saveSession(logInResponse: LogInResponse?){
        logInResponse?.let {
            if(it.email!=null && it.token!=null){
                PreferencesHelper.saveSession(this,it.email,it.token)
            }
        }
    }

    private fun goToNoteList(){
        val intent= Intent(this,NoteListActivity::class.java)
        startActivity(intent)
    }

    private fun showMessage(message: String?) {
        Toast.makeText(this@LogInActivity,
                "LogIn $message", Toast.LENGTH_LONG).show()
        //Log.v("CONSOLE", "$message")
        NLog.v(message)
    }

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

    private fun showLoading() {
        flayLoading.visibility= View.VISIBLE
    }

    private fun hideLoading() {
        flayLoading.visibility= View.GONE
    }
}
