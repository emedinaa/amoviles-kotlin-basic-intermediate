package com.kotlin.samples.kotlinapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.NoteEntity

class NoteAdapter(options: FirebaseRecyclerOptions<NoteEntity>) : FirebaseRecyclerAdapter<NoteEntity, NoteViewHolder>(options) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return NoteViewHolder(inflater.inflate(R.layout.row_note, viewGroup, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int, model: NoteEntity) {
        //val item= getRef(position)
        holder.tviName.text= model.name
    }
}