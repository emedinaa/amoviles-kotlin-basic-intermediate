package com.kotlin.samples.kotlinapp

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_keyboard_events.*



class KeyboardEventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard_events)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ui()
    }

    private fun ui(){
        eteUsername.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.v("CONSOLE", "afterTextChanged ${s.toString()}")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.v("CONSOLE", "beforeTextChanged ${s.toString()}")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.v("CONSOLE", "onTextChanged ${s.toString()}")
            }

        })

        etePassword.setOnEditorActionListener { _, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                send()
            }
            false
        }

        btnSignUp.setOnClickListener {
            hideKeyboard()
            send()
        }
    }

    private fun send(){
        showMessage("Sending to server...")
    }

    private fun showMessage(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun hideKeyboard() {
        (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
                .toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
    }

    private fun showKeyboard() {
        (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
                .toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /*override fun onSupportNavigateUp(): Boolean {
      onBackPressed()
      return true
  }*/
}
