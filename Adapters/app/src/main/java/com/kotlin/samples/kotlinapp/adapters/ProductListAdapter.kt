package com.kotlin.samples.kotlinapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.Product

class ProductListAdapter(private val context: Context,
                         private val data:List<Product>): BaseAdapter() {

    private val mInflater: LayoutInflater=LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.row_product, parent, false)
            vh = ListRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        val product= data[position]

        vh.textViewName.text =  product.name
        vh.textViewPrice.text= "S/.".plus(product.price) //"S/.${product.price}"

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
        val textViewName: TextView = row?.findViewById(R.id.textViewName) as TextView
        val textViewPrice: TextView = row?.findViewById(R.id.textViewPrice) as TextView
        val imageViewProduct: ImageView = row?.findViewById(R.id.imageViewProduct) as ImageView
    }
}