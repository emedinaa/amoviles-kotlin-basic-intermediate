package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kotlin.samples.kotlinapp.extensions.isValidEmail
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    private var name:String=""
    private var email:String=""
    private var password1:String=""
    private var password2:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ui()
    }

    private fun ui(){
        butSignUp.setOnClickListener {
            if(validateForm()){
                //enviar al servidor
                showMessage()
            }
        }
    }

    private fun validateForm():Boolean{
        //TODO capturar lo que usuario ingreso
        name= eteName.text.toString().trim()
        email= eteEmail.text.toString().trim()
        password1= etePassword1.text.toString().trim()
        password2= etePassword2.text.toString().trim()

        Log.v("CONSOLE", " name $name email $email password1 $password1 password2 $password2")

        if(name.isEmpty()){
            eteName.error="Ingresar el nombre"
            return false
        }

        if(email.isEmpty()){
            eteEmail.error="Ingresar el e-mail"
            return false
        }

        if(!email.isValidEmail()){
            eteEmail.error="E-mail inválido"
            return false
        }

        if(password1.isEmpty()){
            etePassword1.error="Ingresar el password"
            return false
        }

        if(password2.isEmpty()){
            etePassword2.error="Ingresar el password"
            return false
        }

        if(!password1.equals(password2)){
            etePassword2.error="No conciden las contraseñas"
            return false
        }
        return true
    }

    private fun showMessage(){
        val builder:AlertDialog.Builder= AlertDialog.Builder(this).apply {
            setTitle("")
            setMessage("Enviando al servidor...")
            setPositiveButton("Aceptar") { dialog, id ->

            }
        }
        val dialog:AlertDialog= builder.create()
        dialog.show()
    }

    private fun clear(){
        eteName.error=null
        eteEmail.error=null
        etePassword1.error=null
        etePassword2.error=null
    }
}
