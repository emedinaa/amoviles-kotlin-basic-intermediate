package com.kotlin.samples.kotlinapp.adapters

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.Pokemon
import java.io.IOException
import java.io.InputStream


/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
class PokemonAdapter(val context:Context, val pokemonList:List<Pokemon>):RecyclerView.Adapter<PokemonAdapter.Companion.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_pokemon,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name= pokemonList[position].name
        val image = pokemonList[position].photo

        holder?.tviName?.text=name
        holder?.iviPhoto.setImageBitmap(getBitmapFromAssets(image))
        holder?.iviPhoto.setOnClickListener {
            //
        }
    }

    fun getBitmapFromAssets(fileName: String): Bitmap {
        val assetManager = context.assets

        var istr: InputStream? = null
        try {
            istr = assetManager.open(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return BitmapFactory.decodeStream(istr)//istr will be null
    }

    companion object {
        class ViewHolder(v:View ):RecyclerView.ViewHolder(v){
            val tviName:TextView=v.findViewById(R.id.tviName)
            val iviPhoto:ImageView= v.findViewById(R.id.iviPhoto)
        }
    }
}