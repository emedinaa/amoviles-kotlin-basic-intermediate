package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kotlin.samples.kotlinapp.model.NoteEntity


class MainActivity : AppCompatActivity() {

    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpDb()

        //addNote
        val note= NoteEntity(null,"Nota 4","Esta es una nota 4")
        mDatabase.child("notes").setValue(note)
    }

    private fun setUpDb(){
        //FirebaseApp.initializeApp(this)
        mDatabase= FirebaseDatabase.getInstance().reference
    }
}
