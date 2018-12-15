package com.kotlin.samples.kotlinapp.sample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.samples.kotlinapp.sample.model.Note
import com.kotlin.samples.kotlinapp.R

class NoteAdapter(val context:Context,val notes:List<Note>):BaseAdapter(){

    private val mInflater: LayoutInflater=LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: ViewHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.row_note, parent, false)
            vh = ViewHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }
        vh.tviName.text = notes[position].name
        return view
    }

    override fun getItem(position: Int): Any {
        return notes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
       return notes.size
    }

    class ViewHolder(view:View){
        val iviNote= view.findViewById<ImageView>(R.id.imageViewNote)
        val tviName= view.findViewById<TextView>(R.id.tviName)
    }
}