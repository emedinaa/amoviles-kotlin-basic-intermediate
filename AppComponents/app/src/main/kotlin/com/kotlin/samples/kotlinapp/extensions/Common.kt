package com.kotlin.samples.kotlinapp.extensions

import android.content.Context
import android.widget.Toast


fun String.replaceJava():String = this.replaceFirst("Java","Kotlin")

fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}
