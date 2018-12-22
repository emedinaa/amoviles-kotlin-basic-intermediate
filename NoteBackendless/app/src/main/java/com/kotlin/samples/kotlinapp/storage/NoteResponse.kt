package com.kotlin.samples.kotlinapp.storage

import com.google.gson.annotations.SerializedName
import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.model.UserEntity

class LogInResponse(@SerializedName("user-token") val token:String?, val objectId:String?, val email:String?, val name:String?,
                    val message:String?, val code:String?)

class NoteResponse(val objectId:String?,val title:String?,val message:String?,val code:String?,
                   val description:String?)










