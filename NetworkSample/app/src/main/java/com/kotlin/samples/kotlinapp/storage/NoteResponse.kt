package com.kotlin.samples.kotlinapp.storage

import com.kotlin.samples.kotlinapp.model.NoteEntity
import com.kotlin.samples.kotlinapp.model.UserEntity

open class BaseResponse(val status:Int?,val msg:String?){
    companion object {
        const val STATUS_CODE:Int=200
    }

    protected fun isSuccess():Boolean {
        return status == STATUS_CODE
    }
}

class LogInResponse(status:Int?,val data:UserEntity?, msg:String?):BaseResponse(status,msg)

class NoteResponse(status:Int?,val data:NoteEntity?, msg:String?):BaseResponse(status,msg)

class NotesResponse(status:Int?,val data:List<NoteEntity>?, msg:String?):BaseResponse(status,msg)

class UserResponse(status:Int?,val data:Any?, msg:String?):BaseResponse(status,msg)

class UsersResponse(status:Int?,val data:List<UserEntity>?, msg:String?):BaseResponse(status,msg)









