package com.kotlin.samples.kotlinapp.ui.view

import com.kotlin.samples.kotlinapp.storage.LogInResponse

/*
Validar formulario ??
Mostrar mensaje de error x
Mostrar progress X
Ocultar progress X
Ir a la pantalla de listado X
Ir a la pantalla de registro X

 */
interface LogInView {

    fun showMessage(message:String?)

    fun hideLoading()
    fun showLoading()

    fun goToNoteList()

    fun saveSession(logInResponse: LogInResponse?)
}