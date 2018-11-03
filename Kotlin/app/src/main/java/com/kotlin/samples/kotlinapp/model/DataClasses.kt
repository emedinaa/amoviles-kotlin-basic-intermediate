package com.kotlin.samples.kotlinapp.model

/**
 * @author : Eduardo Medina
 * @since : 11/3/18
 * @see : https://developer.android.com/index.html
 */

data class User(val name: String, val age: Int)

data class Adult(val name: String) {
    var age: Int = 0
}