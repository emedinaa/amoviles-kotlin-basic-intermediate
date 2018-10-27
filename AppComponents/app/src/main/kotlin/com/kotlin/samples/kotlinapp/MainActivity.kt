package com.kotlin.samples.kotlinapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import com.kotlin.samples.kotlinapp.extensions.replaceJava
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var angle:Double=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message:String= "Hello Java".replaceJava()
        textView.text= message

        textView.setOnClickListener {
            //toast(message, Toast.LENGTH_SHORT)
            addKotlinView()
        }
    }

    private fun addKotlinView(){
        val layoutParams= FrameLayout.LayoutParams(100,100)
        layoutParams.gravity= Gravity.CENTER

        val view= ImageView(this)
        view.setImageResource(R.mipmap.img_kotlin)
        view.layoutParams= layoutParams
        //animateView(view)
        //animateView2(view)
        frameLayout.addView(view)
    }

    private fun animateView2(view: View){
        Log.v("CONSOLE","angle $angle")
        val radius= screenSize().x.toFloat()/2-100
        val nX = radius * Math.cos(angle).toFloat()
        val nY = radius * Math.sin(angle).toFloat()
        view.animate().translationXBy(nX).translationYBy(nY).duration=1000
        angle-=Math.toRadians(10.0)
    }

    private fun animateView(view: View){
        Log.v("CONSOLE","angle $angle")

        val radius= screenSize().x.toFloat()/2-100
        val nX = radius * Math.cos(angle).toFloat()
        val nY = radius * Math.sin(angle).toFloat()

        val animX=ObjectAnimator.ofFloat(view, "translationX",nX)
        val animY=ObjectAnimator.ofFloat(view, "translationY",nY)

        AnimatorSet().apply {
            playTogether(animX, animY)
            interpolator=DecelerateInterpolator()
            duration=800
            startDelay=10
            start()
        }

        angle-=Math.toRadians(10.0)

    }

    private fun screenSize():Point{
        val point= Point()
        windowManager.defaultDisplay.getSize(point)
        return point
    }

}
