package com.kotlin.samples.kotlinapp.sample

import android.content.Context
import android.content.SharedPreferences

object PreferencesHelper {

    private val MYNOTES_PREFERENCES = "com.kotlin.samples.kotlinapp"
    private val PREFERENCES_USERNAME = "$MYNOTES_PREFERENCES.username"


    fun saveSession(context: Context, username: String) {
        val editor = getEditor(context)
        editor.putString(PREFERENCES_USERNAME, username)
        editor.apply()
    }

    fun userSession(context: Context): String? {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getString(PREFERENCES_USERNAME, null)
    }

    fun isSignedIn(context: Context): Boolean {
        val preferences = getSharedPreferences(context)
        return preferences.contains(PREFERENCES_USERNAME)
    }

    fun clearSession(context: Context){
        val editor = getEditor(context)
        editor.remove(PREFERENCES_USERNAME)
        editor.apply()
    }

    fun clear(context: Context){
        val editor = getEditor(context)
        editor.clear()
        editor.apply()
    }

    private fun getEditor(context: Context): SharedPreferences.Editor {
        val preferences = getSharedPreferences(context)
        return preferences.edit()
    }

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(MYNOTES_PREFERENCES, Context.MODE_PRIVATE)
    }
}