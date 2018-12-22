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
import com.kotlin.samples.kotlinapp.ui.dialog.NoteDialogFragment
import kotlinx.android.synthetic.main.activity_edit_note.*
import kotlinx.android.synthetic.main.layout_loading.*

class EditNoteActivity : AppCompatActivity(),NoteDialogFragment.DialogListener {

    private lateinit var mDatabase: DatabaseReference
    private var note: NoteEntity?=null

    private var name:String?=null
    private var desc:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        verifyExtras()
        mDatabase= FirebaseDatabase.getInstance().reference
        ui()
        populate()
    }

    private fun ui(){
        btnEditNote.setOnClickListener {
            if(validateForm()){
                editNote()
            }
        }

        btnDeleteNote.setOnClickListener {
            showNoteDialog()
        }
    }

    private fun validateForm():Boolean{
        name= eteName.text.toString()
        desc= eteDesc.text.toString()

        if(name.isNullOrEmpty()){
            return false
        }

        if(desc.isNullOrEmpty()){
            return false
        }

        return true
    }

    private fun populate(){
        note?.let {
            eteName.setText(it?.name)
            eteDesc.setText(it?.description)
        }
    }

    private fun showErrorMessage(error: String?) {
        Toast.makeText(this, "Error : $error", Toast.LENGTH_SHORT).show()
    }

    private fun showNoteDialog(){
        val noteDialogFragment= NoteDialogFragment()
        val bundle= Bundle()
        bundle.putString("TITLE","¿Deseas eliminar esta nota?")
        bundle.putInt("TYPE",100)

        noteDialogFragment.arguments= bundle
        noteDialogFragment.show(supportFragmentManager,"dialog")
    }


    override fun onPositiveListener(any: Any?, type: Int) {
        note?.let {
            //noteRepository?.deleteNote(it)
            deleteNote(it)
        }
        //finish()
    }

    override fun onNegativeListener(any: Any?, type: Int) {}

    private fun deleteNote(mNote:NoteEntity){
        showLoading()
        mNote.id?.let {
            mDatabase.child("notes").child(it).removeValue(object: DatabaseReference.CompletionListener{
                override fun onComplete(databaseError: DatabaseError?, databaseReference: DatabaseReference) {
                    hideLoading()
                    databaseError?.let {
                        showErrorMessage(databaseError.message)
                    }?:run{
                        finish()
                    }
                }
            })
        }
    }

    private fun editNote() {
        showLoading()
        val noteId = note?.id
        val note= NoteEntity(noteId,name,desc)

        noteId?.let {
            mDatabase.child("notes").child(it).updateChildren(note.toMap(),object: DatabaseReference.CompletionListener{
                override fun onComplete(databaseError: DatabaseError?, databaseReference: DatabaseReference) {
                    hideLoading()
                    databaseError?.let {
                        showErrorMessage(databaseError.message)
                    }?:run{
                        finish()
                    }
                }
            })
        }
    }

    private fun verifyExtras(){
        intent?.extras?.let {
            note= it.getSerializable("NOTE") as NoteEntity
        }
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
