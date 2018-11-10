package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    private var count:Int=0
    private lateinit var images:MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        init()
    }

    private fun init(){
        images= mutableListOf(R.drawable.sample_0,
                R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,
                R.drawable.sample_4,R.drawable.sample_5,R.drawable.sample_6,
                R.drawable.sample_7)
        //first image
        firstImage()
        //ui events
        img.setOnClickListener {
            nextImage()
        }
    }

    private fun firstImage(){
        img.setImageResource(images[0])
        count=0
        txtImg.text= "Imagen $count"
    }

    // 0 1 2 3 4 5 6 7
    //count
    private fun nextImage(){
        Log.v("CONSOLE", "count $count")
        count++//count=count+1 -1
        if(count>=images.size){
            count=0
        }
        img.setImageResource(images[count])
        txtImg.text= "Imagen $count"

        Log.v("CONSOLE", "image ${images[count]}")
        Log.v("CONSOLE", "count $count")
    }

    fun click_handler(view:View){
        nextImage()
    }
}
