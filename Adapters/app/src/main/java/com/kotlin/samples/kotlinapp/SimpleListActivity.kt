package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import com.kotlin.samples.kotlinapp.adapters.SimpleListAdapter
import com.kotlin.samples.kotlinapp.extensions.toast
import kotlinx.android.synthetic.main.activity_simple_list.*

/*
       1. Data Provider : List, ArrayList, Array
       2. View Container : ListView, GridView, RecyclerView
       3. Entity : Entity class
       4. Row : view Xml
       5. Adapter: ArrayAdapter , BaseAdapter, CursorAdapter
       6. Set Adapter to the View container

*/

class SimpleListActivity : AppCompatActivity() {

    private val mDays:Array<String> = arrayOf("Monday", "Tuesday","Wednesday","Thursday","Friday",
            "Saturday", "Sunday")

    private val mMonths= arrayOf("January", "February","March","April","May",
            "June", "July", "August","September", "October", "November","December")

    private val mPlanets= arrayOf("Mercury", "Venus","Earth","Mars","Pluto",
            "Jupiter", "Saturn", "Uranus","Neptune")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)

        //adapter
        val arrayAdapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mDays)

        val arrayAdapter1= ArrayAdapter<String>(this,R.layout.row,mDays)

        val adapter= SimpleListAdapter(this, mDays)

        listViewMovies.adapter= arrayAdapter
        //listViewMovies.adapter= arrayAdapter1
        //listViewMovies.adapter= adapter

        //events
        listViewMovies.setOnItemClickListener { adapterView, view, position, l ->
            val item= "$position : ${adapterView.adapter.getItem(position)}"
            toast(item,Toast.LENGTH_SHORT)
        }
    }
}
