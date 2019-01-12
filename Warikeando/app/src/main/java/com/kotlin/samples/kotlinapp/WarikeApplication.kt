package com.kotlin.samples.kotlinapp

import android.app.Application
import com.kotlin.samples.kotlinapp.model.storage.WarikeRepository

class WarikeApplication:Application() {

    private lateinit var warikeRepository: WarikeRepository

    override fun onCreate() {
        super.onCreate()
        warikeRepository= WarikeRepository(this)
    }

    fun getWarikeRepository(): WarikeRepository {
        return warikeRepository
    }

}