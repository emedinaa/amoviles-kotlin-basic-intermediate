package com.kotlin.samples.kotlinapp.data

import com.kotlin.samples.kotlinapp.model.Pokemon

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
object PokemonData {

    fun getPokemosList():List<Pokemon> {
        val pokemonList: MutableList<Pokemon> = arrayListOf()
        pokemonList.add(Pokemon(0,"Abra","","images/Abra.png"))
        pokemonList.add(Pokemon(0,"Arcanine","","images/Arcanine.png"))
        pokemonList.add(Pokemon(0,"Bulbasaur","","images/Bulbasaur.png"))
        pokemonList.add(Pokemon(0,"Caterpie","","images/Caterpie.png"))
        pokemonList.add(Pokemon(0,"Drowzee","","images/Drowzee.png"))
        return pokemonList.toList()
    }
}