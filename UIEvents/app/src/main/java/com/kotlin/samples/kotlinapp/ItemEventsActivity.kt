package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_item_events.*

class ItemEventsActivity : AppCompatActivity() {

    private var location:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_events)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ui()
        //uiFlag()
    }

    private fun uiFlag(){
        //spLocation.tag="Empty"
        spLocation.tag=null
        spLocation.onItemSelectedListener= object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                spLocation.tag?.let {
                    location= adapterView?.adapter?.getItem(i).toString()
                    showMessage("Item selected $location")

                }?:run{
                    spLocation.tag="Empty"
                }
            }
        }
    }

    private fun ui(){
        spLocation.onItemSelectedListener= object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                location= adapterView?.adapter?.getItem(i).toString()
                showMessage("Item selected $location")
            }
        }
    }

    private fun showMessage(msg: String?) {
        Log.v("CONSOLE",msg)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    /*override fun onSupportNavigateUp(): Boolean {
     onBackPressed()
     return true
    }*/
}
