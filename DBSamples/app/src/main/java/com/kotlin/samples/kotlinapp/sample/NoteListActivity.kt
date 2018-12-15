package com.kotlin.samples.kotlinapp.sample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.sample.adapter.NoteAdapter
import com.kotlin.samples.kotlinapp.sample.model.Note
import com.kotlin.samples.kotlinapp.sample.storage.NoteDatabase
import com.kotlin.samples.kotlinapp.sample.storage.NoteRepository
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private lateinit var noteRepository: NoteRepository
    private lateinit var notes:List<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupRepository()
        ui()
    }

    private fun ui(){
        btnAddNote.setOnClickListener {
            goToAddNote()
        }

        lstNotes.setOnItemClickListener { parent, view, position, id ->
            if(notes.isNotEmpty()){
                val note:Note= notes[position]
                goToNote(note)
            }
        }
    }

    private fun setupRepository(){
        noteRepository= NoteRepository(NoteDatabase(this))
    }

    override fun onResume() {
        super.onResume()
        loadNotes()
    }

    private fun loadNotes(){
        notes= noteRepository.notes()
        lstNotes.adapter= NoteAdapter(this,notes)
    }


    private fun goToAddNote(){
        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    private fun goToNote(note:Note){
        val bundle= Bundle()
        bundle.putSerializable("NOTE",note)
        val intent= Intent(this,EditNoteActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
