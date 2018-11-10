package com.kotlin.samples.kotlinapp.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.Movie

class MovieListAdapter(private val context: Context,
                       private val data:List<Movie>): BaseAdapter() {

    private val mInflater: LayoutInflater=LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.row_movie_list, parent, false)
            vh = ListRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        val movie= data[position]

        vh.tviName.text =  movie.title
        vh.iviCartelera.visibility= if(movie.cartelera) View.VISIBLE else View.GONE
        vh.tviName.setTextColor(if(position==0) Color.GREEN else Color.BLACK)

        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

    private class ListRowHolder(row: View?) {
        val tviName: TextView = row?.findViewById(R.id.tviName) as TextView
        val iviCartelera: ImageView = row?.findViewById(R.id.iviCartelera) as ImageView
    }
}