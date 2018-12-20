package com.kotlin.samples.kotlinapp.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.storage.NoteApiClient
import com.kotlin.samples.kotlinapp.storage.NoteRepository
import com.kotlin.samples.kotlinapp.storage.NotesResponse
import kotlinx.android.synthetic.main.activity_note_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import com.kotlin.samples.kotlinapp.ui.adapter.NoteAdapter
import kotlinx.android.synthetic.main.layout_loading.*


class NoteListActivity : AppCompatActivity() {

    private lateinit var noteRepository: NoteRepository
    private var call:Call<NotesResponse>?=null

    private var notes:List<NoteEntity>?=null

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
            notes?.let {
                if(it.isNotEmpty()){
                    val note:NoteEntity= it[position]
                    goToNote(note)
                }
            }
        }
    }

    private fun setupRepository(){
        noteRepository= NoteRepository()
    }

    override fun onResume() {
        super.onResume()
        loadNotes()
    }

    private fun loadNotes(){
        //notes= noteRepository.notes()
        //lstNotes.adapter= NoteAdapter(this,notes)
        showLoading()
        call= NoteApiClient.build()?.notes()

        call?.enqueue(object :Callback<NotesResponse>{
            override fun onFailure(call: Call<NotesResponse>, t: Throwable) {
                hideLoading()
                showErrorMessage(t.message)
            }

            override fun onResponse(call: Call<NotesResponse>, response: Response<NotesResponse>) {
                hideLoading()
                response?.body()?.let {
                    if(response.isSuccessful){
                        renderNotes(it.data)
                    }else{
                        showErrorMessage(response.errorBody()?.string())
                    }
                }
            }
        })
    }

    private fun renderNotes(mNotes:List<NoteEntity>?){
        notes= mNotes
        notes?.let {
            lstNotes.adapter= NoteAdapter(this,it)
        }
    }

    override fun onPause() {
        super.onPause()
        call?.cancel()
    }

    private fun showErrorMessage(error: String?) {
        Toast.makeText(this, "Error : $error", Toast.LENGTH_SHORT).show()
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


    private fun showLoading() {
        flayLoading.visibility=View.VISIBLE
    }

    private fun hideLoading() {
        flayLoading.visibility=View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
