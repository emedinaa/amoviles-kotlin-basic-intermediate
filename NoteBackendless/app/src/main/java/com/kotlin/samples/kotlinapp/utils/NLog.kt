package com.kotlin.samples.kotlinapp.utils

import com.kotlin.samples.kotlinapp.BuildConfig
import android.util.Log


object NLog {

    private val TAG = "CONSOLE"

    fun v(message: String?) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, message)
        }
    }

    fun d(message: String?) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message)
        }
    }
}