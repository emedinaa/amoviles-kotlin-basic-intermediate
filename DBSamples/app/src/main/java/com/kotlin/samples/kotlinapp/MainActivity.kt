package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.basic.DBBasicActivity
import com.kotlin.samples.kotlinapp.sample.NoteListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBasic.setOnClickListener {
            goToView(DBBasicActivity::class.java)
        }

        buttonSample.setOnClickListener {
            goToView(NoteListActivity::class.java)
        }
    }

    private fun goToView(viewClass:Class<*>){
        startActivity(Intent(this,viewClass))
    }
}
