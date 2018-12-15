package com.kotlin.samples.kotlinapp.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.sample.model.Note
import com.kotlin.samples.kotlinapp.sample.storage.NoteDatabase
import com.kotlin.samples.kotlinapp.sample.storage.NoteRepository

class DBBasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbbasic)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        db()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun db(){
        val noteRepository= NoteRepository(NoteDatabase(this))

        //agregar paradero
        /*noteRepository.addNote(Note(null,"Nota 1", "Nota 1"))
        noteRepository.addNote(Note(null,"Nota 2", "Nota 2"))*/


        //listar paraderos
        val notes:List<Note> = noteRepository.notes()
        notes.forEach {
            Log.v("CONSOLE", "note $it")
        }


        //eliminar paradero
        //noteRepository.deleteNote()

        //editar paradero
        //noteRepository.updateNote()
    }
}
