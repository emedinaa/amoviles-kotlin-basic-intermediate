package com.kotlin.samples.kotlinapp.sample.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class NoteDatabase(context:Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION:Int=1
        const val DATABASE_NAME:String="BDNote"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = ("CREATE TABLE ${NoteTable.NAME} ("
                + "${NoteTable.KEY_ID} INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , ${NoteTable.KEY_NAME}  TEXT,"
                + "${NoteTable.KEY_DESC} TEXT )")

        Log.v("CONSOLE","sql $sql")
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS ${NoteTable.NAME}"
        db?.execSQL(sql)
    }
}