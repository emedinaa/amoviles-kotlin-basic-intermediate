package com.kotlin.samples.kotlinapp.model

import java.io.Serializable


data class UserEntity(val id:String?,val username:String?,val firstname:String?,
                      val lastname:String?):Serializable

data class NoteEntity(val objectId:String?,val title:String?,
                      val description:String?):Serializable