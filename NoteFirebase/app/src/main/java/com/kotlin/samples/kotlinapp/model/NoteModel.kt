package com.kotlin.samples.kotlinapp.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class NoteEntity(val id:Int?,val name:String?, val description:String?)