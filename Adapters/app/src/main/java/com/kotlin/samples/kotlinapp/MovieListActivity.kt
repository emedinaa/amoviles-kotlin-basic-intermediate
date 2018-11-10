package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kotlin.samples.kotlinapp.adapters.MovieListAdapter
import com.kotlin.samples.kotlinapp.data.Movies
import com.kotlin.samples.kotlinapp.extensions.toast
import com.kotlin.samples.kotlinapp.model.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*

/*
      1. Data Provider : List, ArrayList, Array
      2. View Container : ListView, GridView, RecyclerView
      3. Entity : Entity class
      4. Row : view Xml
      5. Adapter: ArrayAdapter , BaseAdapter, CursorAdapter
      6. Set Adapter to the View container
      */

class MovieListActivity : AppCompatActivity() {

    private var movies:List<Movie> = arrayListOf()
    private var adapter:MovieListAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        //1 data provider movies
        //2 Contenedor listViewMovies
        //3 Entidad Movie
        //4 Celda row_movie_list.xml
        //5 Adapter MovieListAdapter
        //6 ListViewMovies.setAdapter(adapter)

        movies= Movies.getMovies()

        //adapter
        adapter= MovieListAdapter(this,movies)

        //set Adapter to UI
        listViewMovies.adapter= adapter

        //events
        listViewMovies.setOnItemClickListener { adapterView, view, position, l ->
            val movie=  adapterView.adapter.getItem(position) as Movie
            val item= "$position : ${movie.title}  ${movie.cartelera}"

            toast(item, Toast.LENGTH_SHORT)
        }

    }
}
