package com.kotlin.samples.kotlinapp.data

import com.kotlin.samples.kotlinapp.model.Movie

/**
 * @author : Eduardo Medina
 * @since : 11/10/18
 * @see : https://developer.android.com/index.html
 */
object Movies {

    fun getMovies():List<Movie>{
        val movieList:MutableList<Movie> = arrayListOf()
        movieList.add(Movie(0,"Batman","",0.0,false))
        movieList.add(Movie(0,"Tiburón","",0.0,false))
        movieList.add(Movie(0,"Batman","",0.0,true))
        movieList.add(Movie(0,"Harry Potter","",0.0,false))
        movieList.add(Movie(0,"LA REINA DE KATWE","",0.0,false))
        movieList.add(Movie(0,"ROBERT EL MUÑECO POSEIDO","",0.0,true))
        movieList.add(Movie(0,"UNA PAREJA DISPAREJA","",0.0,false))
        movieList.add(Movie(0,"ENEMIGO EN LA RED","",0.0,false))
        movieList.add(Movie(0,"Batman","",0.0,true))
        movieList.add(Movie(0,"Tiburón","",0.0,false))

        return  movieList.toList()
    }
}