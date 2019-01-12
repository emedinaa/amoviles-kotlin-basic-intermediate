package com.kotlin.samples.kotlinapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        ui()
    }

    private fun ui(){
        imageViewMap.setOnClickListener {
            next(PlaceMapActivity::class.java,null,false)
        }

        imageViewCamera.setOnClickListener {
            next(PlaceRegistrationActivity::class.java,null,false)
        }
    }

}
