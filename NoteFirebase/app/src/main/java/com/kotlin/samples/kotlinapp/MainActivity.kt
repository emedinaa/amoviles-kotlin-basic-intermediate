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
        val noteId = mDatabase.child("notes").push().key
        val note= NoteEntity(noteId,"Nota 8","Esta es una nota 8")
        noteId?.let {
            mDatabase.child("notes").child(noteId).setValue(note)
        }

    }

    private fun setUpDb(){
        mDatabase= FirebaseDatabase.getInstance().reference
    }
}
