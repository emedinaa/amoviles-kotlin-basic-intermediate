package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager

import com.kotlin.samples.kotlinapp.fragments.ShowMessageFragment
import com.kotlin.samples.kotlinapp.fragments.WriteMessageFragment
import com.kotlin.samples.kotlinapp.listeners.MessageListener
import com.kotlin.samples.kotlinapp.R

class FCommunicationActivity : AppCompatActivity(),MessageListener {

    private lateinit var fragmentManager: FragmentManager
    private var  writeMessageFragment: WriteMessageFragment?=null
    private var  showMessageFragment: ShowMessageFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcommunication)

        fragmentManager = supportFragmentManager

        if (fragmentManager.findFragmentById(R.id.fragmentWriteMessage) is WriteMessageFragment) {
            writeMessageFragment= fragmentManager.findFragmentById(R.id.fragmentWriteMessage) as WriteMessageFragment
        }

        if (fragmentManager.findFragmentById(R.id.fragmentShowMessage) is ShowMessageFragment) {
            showMessageFragment= fragmentManager.findFragmentById(R.id.fragmentShowMessage) as ShowMessageFragment
        }
    }

    override fun recibiryEnviardesdeFragment(message: String?) {
        showMessageFragment?.mostrarMensaje(message)
    }
}
