package com.kotlin.samples.kotlinapp.presenters

import com.kotlin.samples.kotlinapp.storage.LogInRaw
import com.kotlin.samples.kotlinapp.storage.LogInResponse
import com.kotlin.samples.kotlinapp.storage.NoteApiClient
import com.kotlin.samples.kotlinapp.storage.NoteConstant
import com.kotlin.samples.kotlinapp.storage.PreferencesHelper.saveSession
import com.kotlin.samples.kotlinapp.ui.view.LogInView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInPresenter(val view:LogInView) {

    private var call: Call<LogInResponse>?=null

    private fun validateForm():Boolean{
        return false
    }

    fun logIn(username:String?, password:String?){
        view.showLoading()
        val logInRaw= LogInRaw(username,password)

        call= NoteApiClient.build()?.logInBL(NoteConstant.APPLICATIONID, NoteConstant.RESTAPIKEY,logInRaw)
        call?.enqueue(object : Callback<LogInResponse> {
            override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                view.hideLoading()
                view.showMessage(t.message)
            }

            override fun onResponse(call: Call<LogInResponse>, response: Response<LogInResponse>) {
                view.hideLoading()
                response?.body()?.let {
                    if(response.isSuccessful){
                        view.saveSession(response.body())
                        view.goToNoteList()
                    }else{
                        view.showMessage(response.errorBody()?.string())
                    }
                }
            }
        })
    }

    fun cancel(){
        call?.cancel()
    }
}