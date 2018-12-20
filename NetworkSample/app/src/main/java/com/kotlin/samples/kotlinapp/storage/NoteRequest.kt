package com.kotlin.samples.kotlinapp.storage

data class LogInRaw(val username:String?,val password:String?)

data class UserRaw(val username:String?,val password:String?, val firstname:String?,
                   val lastname:String?)

data class NoteRaw(val id:String?,val name:String?, val description:String?,
                   val userId:String?)