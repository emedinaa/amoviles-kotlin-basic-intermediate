package com.kotlin.samples.kotlinapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.samples.kotlinapp.R

class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val iviNote= view.findViewById<ImageView>(R.id.imageViewNote)
    val tviName= view.findViewById<TextView>(R.id.tviName)
}