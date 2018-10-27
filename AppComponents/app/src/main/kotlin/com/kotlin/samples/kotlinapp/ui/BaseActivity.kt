package com.kotlin.samples.kotlinapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity



/**
 * @author : Eduardo Medina
 * @since : 10/27/18
 * @see : https://developer.android.com/index.html
 */
open abstract class BaseActivity : AppCompatActivity() {

    protected fun next(activityClass: Class<*>, bundle: Bundle?, destroy: Boolean) {
        val intent = Intent(this, activityClass)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
        if (destroy) {
            finish()
        }
    }
}