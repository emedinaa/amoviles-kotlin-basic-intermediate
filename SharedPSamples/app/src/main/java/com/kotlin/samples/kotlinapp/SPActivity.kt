package com.kotlin.samples.kotlinapp

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.R
import kotlinx.android.synthetic.main.activity_sp.*

class SPActivity : AppCompatActivity(),SharedPreferences.OnSharedPreferenceChangeListener {


    private lateinit var mSharedPreferences:SharedPreferences
    private lateinit var mSharedPreferencesEditor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)
        setUpSp()
        ui()
    }

    private fun setUpSp(){
        mSharedPreferences= getSharedPreferences("com.kotlin.samples.kotlinapp.sp",
                Context.MODE_PRIVATE)
        //Context.MODE_APPEND
        mSharedPreferencesEditor= mSharedPreferences.edit()
    }

    private fun ui(){
        textView.text=""

        buttonSave.setOnClickListener {
            saveParameters()
        }

        buttonClear.setOnClickListener {
            clearParameters()
        }
    }

    private fun saveParameters(){
        mSharedPreferencesEditor.putInt("USERID", 100)
        mSharedPreferencesEditor.putString("USERNAME", "edu")
        mSharedPreferencesEditor.putBoolean("STATE", false)
        mSharedPreferencesEditor.apply()
    }

    private fun clearParameters(){
        mSharedPreferencesEditor.clear()
        mSharedPreferencesEditor.apply()
        textView.text=""
    }

    private fun renderParameters(){
        val userId= mSharedPreferences.getInt("USERID",0)
        val userName= mSharedPreferences.getString("USERNAME","")
        val state= mSharedPreferences.getBoolean("STATE",false)
        textView.text= "userId : $userId \n userName : $userName \n state : $state"
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        renderParameters()
    }

    override fun onResume() {
        super.onResume()
        mSharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }
}
