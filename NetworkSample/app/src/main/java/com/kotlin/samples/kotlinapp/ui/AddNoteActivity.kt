package com.kotlin.samples.kotlinapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.storage.*
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.layout_loading.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddNoteActivity : AppCompatActivity() {

    private lateinit var noteRepository: NoteRepository
    private var call: Call<NoteResponse>?=null

    private var name:String?=null
    private var desc:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupRepository()
        ui()
    }


    private fun ui(){
        btnAddNote.setOnClickListener {
            if(validateForm()){
                addNote()
                //finish()
            }
        }
    }

    private fun addNote(){
        showLoading()
        val raw= NoteRaw(null,name,desc,"001")
        //noteRepository.addNote(note)
        call= NoteApiClient.build()?.addNote(raw)
        call?.enqueue(object :Callback<NoteResponse>{
            override fun onFailure(call: Call<NoteResponse>, t: Throwable) {
                hideLoading()
                showErrorMessage(t.message)
            }

            override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {
                hideLoading()
                response?.body()?.let {
                    if(response.isSuccessful){
                        finish()
                    }else{
                        showErrorMessage(response.errorBody()?.string())
                    }
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        call?.cancel()
    }

    private fun clearForm(){
        eteName.error=null
        eteDesc.error=null
    }

    private fun showErrorMessage(error: String?) {
        Toast.makeText(this, "Error : $error", Toast.LENGTH_SHORT).show()
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

    private fun setupRepository(){
        noteRepository= NoteRepository()
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
