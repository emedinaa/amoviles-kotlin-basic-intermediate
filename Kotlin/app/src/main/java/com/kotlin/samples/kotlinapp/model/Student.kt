package com.kotlin.samples.kotlinapp.model

import android.util.Log

/**
 * @author : Eduardo Medina
 * @since : 11/2/18
 * @see : https://developer.android.com/index.html
 */
class Student(var id:Int,val name:String, val lastName:String,
              val email:String,val age:Int) {

    //var dni:String

    init {
        //TODO
    }

    override fun toString(): String {
        return "Student(id=$id, name='$name', lastName='$lastName', email='$email', age=$age)"
    }

    fun run(){
        Log.v("CONSOLE","run...")
    }

}
