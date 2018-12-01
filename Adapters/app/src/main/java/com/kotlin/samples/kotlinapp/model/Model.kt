package com.kotlin.samples.kotlinapp.model

import java.io.Serializable

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
data class Pokemon(val id:Int,val name:String,val desc:String,
                   val photo:String):Serializable

data class NPerson(val name:String,val nickname:String)