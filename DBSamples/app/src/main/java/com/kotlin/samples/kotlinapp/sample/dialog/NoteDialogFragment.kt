package com.kotlin.samples.kotlinapp.sample.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog

class NoteDialogFragment:DialogFragment() {

    private var listener:DialogListener?=null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog{
        val title= arguments?.getString("TITLE")
        val type= arguments?.getInt("TYPE")

        return AlertDialog.Builder(activity!!)
                .setTitle(title)
                .setPositiveButton("ACEPTAR") { _, _ ->
                    listener?.onPositiveListener(null,type?:0)
                }
                .setNegativeButton("CANCELAR") { _, _ ->
                    listener?.onNegativeListener(null,type?:0)
                }
                .create()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is DialogListener){
            listener= context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener= null
    }


    interface DialogListener{
        fun onPositiveListener(any:Any?,type:Int)
        fun onNegativeListener(any:Any?,type:Int)
    }
}