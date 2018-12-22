package com.kotlin.samples.kotlinapp.model

import android.support.annotation.Keep
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@Keep
@IgnoreExtraProperties
data class NoteEntity(val id:String?="",val name:String?="", val description:String?=""):Serializable{

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
                "id" to id,
                "name" to name,
                "description" to description
        )
    }
}