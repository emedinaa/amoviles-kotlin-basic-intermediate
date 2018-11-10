package com.kotlin.samples.kotlinapp.model

/**
 * @author : Eduardo Medina
 * @since : 11/3/18
 * @see : https://developer.android.com/index.html
 */

data class Person2(val id:Int)

data class Product(val id:Int, val price:Double?=0.0)

data class Car(val id:Int, val brand:String)
