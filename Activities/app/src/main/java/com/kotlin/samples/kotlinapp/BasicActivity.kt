package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open abstract class BasicActivity :AppCompatActivity() {

    protected fun next(activityClass:Class<*>,bundle:Bundle?,destroy:Boolean?=true){

    }
}