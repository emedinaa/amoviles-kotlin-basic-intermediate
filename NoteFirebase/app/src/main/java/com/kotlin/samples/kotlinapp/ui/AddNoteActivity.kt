package com.kotlin.samples.kotlinapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.NoteEntity
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.layout_loading.*

class AddNoteActivity : AppCompatActivity() {

    private lateinit var mDatabase: DatabaseReference

    private var name:String?=null
    private var desc:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mDatabase= FirebaseDatabase.getInstance().reference
        ui()
    }

    private fun ui(){
        btnAddNote.setOnClickListener {
            if(validateForm()){
                addNote()
            }
        }
    }

    private fun addNote(){
        showLoading()
        val noteId = mDatabase.child("notes").push().key
        val note= NoteEntity(noteId,name,desc)
        noteId?.let {
            mDatabase.child("notes").child(it).setValue(note,object:DatabaseReference.CompletionListener{
                override fun onComplete(databaseError: DatabaseError?, databaseReference: DatabaseReference) {
                    hideLoading()
                    databaseError?.let {dbError ->
                        showErrorMessage(dbError.message)
                    }?:run{
                        finish()
                    }
                }
            })
        }
    }

    private fun showErrorMessage(error: String?) {
        Toast.makeText(this, "Error : $error", Toast.LENGTH_SHORT).show()
    }

    private fun clearForm(){
        eteName.error=null
        eteDesc.error=null
    }

    private fun validateForm():Boolean{
        clearForm()
        name= eteName.text.toString().trim()
        desc= eteDesc.text.toString().trim()

        if(name.isNullOrEmpty()){
            eteName.error="Campo nombre inválido"
            return false
        }

        if(desc.isNullOrEmpty()){
            eteDesc.error="Campo descripción inválido"
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
