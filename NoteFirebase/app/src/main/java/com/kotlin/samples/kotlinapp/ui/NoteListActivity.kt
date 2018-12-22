package com.kotlin.samples.kotlinapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.ui.adapter.NoteAdapter
import com.kotlin.samples.kotlinapp.ui.adapter.RecyclerClickListener
import com.kotlin.samples.kotlinapp.ui.adapter.RecyclerTouchListener
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private lateinit var mDatabase: DatabaseReference
    private var noteAdapter:NoteAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpFirebaseDb()
        ui()
    }

    private fun ui(){
        recyclerViewNotes.layoutManager= LinearLayoutManager(this)
        recyclerViewNotes.setHasFixedSize(true)
        loadNotes()

        //events
        btnAddNote.setOnClickListener {
            goToAddNote()
        }

        recyclerViewNotes.addOnItemTouchListener(RecyclerTouchListener(this, recyclerViewNotes,
                object:RecyclerClickListener{
                    override fun onClick(view: View, position: Int) {
                        val note:NoteEntity?=noteAdapter?.getItem(position)
                        note?.let {
                            goToNote(note)
                        }
                    }

                    override fun onLongClick(view: View, position: Int) {}
                }))
    }

    private fun setUpFirebaseDb(){
        mDatabase= FirebaseDatabase.getInstance().reference
    }

    private fun loadNotes(){
        val notesQuery:Query = mDatabase.child("notes")
        val options= FirebaseRecyclerOptions.Builder<NoteEntity>()
                .setQuery(notesQuery,NoteEntity::class.java)
                .build()

        noteAdapter= NoteAdapter(options)
        recyclerViewNotes.adapter= noteAdapter

    }


    override fun onStart() {
        super.onStart()
        noteAdapter?.startListening()
    }

    public override fun onStop() {
        super.onStop()
        noteAdapter?.stopListening()
    }

    private fun goToAddNote(){
        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    private fun goToNote(note:NoteEntity){
        val bundle= Bundle()
        bundle.putSerializable("NOTE",note)
        val intent= Intent(this,EditNoteActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
