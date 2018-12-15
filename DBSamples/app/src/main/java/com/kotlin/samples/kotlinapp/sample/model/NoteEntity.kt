package com.kotlin.samples.kotlinapp.sample.model

import java.io.Serializable

data class Note(val id:Int?, val name:String?,val description:String?):Serializable{

    override fun toString(): String {
        return "Note(id=$id, name=$name, description=$description)"
    }
}