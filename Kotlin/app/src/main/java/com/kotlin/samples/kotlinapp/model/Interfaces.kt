package com.kotlin.samples.kotlinapp.model

/**
 * @author : Eduardo Medina
 * @since : 11/3/18
 * @see : https://developer.android.com/index.html
 */
interface MyInterface {
    fun bar()
    fun foo() {
        // optional body
    }
}

class Child : MyInterface {
    override fun bar() {
        // body
    }
}