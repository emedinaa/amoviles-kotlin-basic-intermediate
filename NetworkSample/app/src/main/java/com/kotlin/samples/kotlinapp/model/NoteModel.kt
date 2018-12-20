package com.kotlin.samples.kotlinapp.model

import java.io.Serializable


data class UserEntity(val id:String?,val username:String?,val firstname:String?,
                      val lastname:String?):Serializable

data class NoteEntity(val id:String?,val name:String?,val description:String?,
                      val userId:String?):Serializable