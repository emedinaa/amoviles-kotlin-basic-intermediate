package com.kotlin.samples.kotlinapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.Person

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
class PersonAdapter(val context: Context, val personList:List<Person>):BaseAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        //pintar la celda
        val view: View?
        val vh: RowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.row_person, parent, false)
            vh = RowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as RowHolder
        }

        //poblar información
        val person= personList[position]

        vh.textViewName.text =person.name
        vh.textViewNickName.text= person.nickName
        return view
    }

    override fun getItem(position: Int): Any {
        return personList[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return personList.size
    }

    private class RowHolder(row: View?) {
        val textViewName: TextView = row?.findViewById(R.id.textViewName) as TextView
        val textViewNickName: TextView = row?.findViewById(R.id.textViewNickName) as TextView
        val imageView3:ImageView= row?.findViewById(R.id.imageView3) as ImageView
    }
}