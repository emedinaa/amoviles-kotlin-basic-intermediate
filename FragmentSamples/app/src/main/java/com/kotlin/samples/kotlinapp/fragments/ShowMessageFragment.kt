package com.kotlin.samples.kotlinapp.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.listeners.MessageListener
import android.widget.TextView
import android.text.TextUtils
import android.util.Log


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowMessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ShowMessageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var listener: MessageListener? = null

    private var tviMessage: TextView? = null
    private var resultMessage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_message, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MessageListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement MessageListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tviMessage = view?.findViewById<View>(R.id.tviMessage) as TextView
        resultMessage = ""
    }

    fun mostrarMensaje(message: String?) {
        Log.v(TAG, " $message")
        if (TextUtils.isEmpty(message)) return

        resultMessage="$resultMessage \n  $message"
        tviMessage?.text=resultMessage
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShowMessageFragment.
         */
        val TAG:String="CONSOLE"
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ShowMessageFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
