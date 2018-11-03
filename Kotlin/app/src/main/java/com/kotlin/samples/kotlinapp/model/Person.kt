package com.kotlin.samples.kotlinapp.model

/**
 * @author : Eduardo Medina
 * @since : 11/2/18
 * @see : https://developer.android.com/index.html
 */
data class Person(var id:Int,var name:String, var lastName:String,
                  var email:String,var age:Int){

    init {

    }
    override fun toString(): String {
        return "Person(id=$id, name='$name', lastName='$lastName', email='$email', age=$age)"
    }
}