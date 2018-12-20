package com.kotlin.samples.kotlinapp.sample.storage

import android.content.ContentValues
import com.kotlin.samples.kotlinapp.sample.model.Note


class NoteRepository(val noteDatabase: NoteDatabase) {

    fun notes():List<Note>{
        val sqliteDatabase= noteDatabase.readableDatabase //modo lectura

        val notes:MutableList<Note> = mutableListOf()
        val sql= "SELECT  * FROM ${NoteTable.NAME}"
        val cursor= sqliteDatabase.rawQuery(sql,null)
        if(cursor.moveToFirst()){
            do{
                val note= Note(cursor.getString(0).toInt(),
                        cursor.getString(1),
                        cursor.getString(2))
                notes.add(note)
            }while(cursor.moveToNext())
        }
        sqliteDatabase.close()
        return notes.toList()
    }

    fun addNote(note:Note){
        val sqliteDatabase= noteDatabase.writableDatabase //modo escritura

        val contentValues=ContentValues()
        contentValues.put(NoteTable.KEY_NAME,note.name)
        contentValues.put(NoteTable.KEY_DESC,note.description)

        sqliteDatabase.insert(NoteTable.NAME,null,contentValues)
        sqliteDatabase.close()
    }

    fun updateNote(note:Note):Int{
        val sqliteDatabase= noteDatabase.writableDatabase //modo escritura
        val contentValues=ContentValues()
        contentValues.put(NoteTable.KEY_NAME,note.name)
        contentValues.put(NoteTable.KEY_DESC,note.description)

        val row= sqliteDatabase.update(NoteTable.NAME,contentValues,
                "${NoteTable.KEY_ID}=?", arrayOf(note.id.toString()))
        sqliteDatabase.close()
        return row
    }

    fun deleteNote(note:Note):Int{
        val sqliteDatabase= noteDatabase.writableDatabase //modo escritura
        val row= sqliteDatabase.delete(NoteTable.NAME,
                "${NoteTable.KEY_ID}=?", arrayOf(note.id.toString()))
        sqliteDatabase.close()
        return row
    }
}