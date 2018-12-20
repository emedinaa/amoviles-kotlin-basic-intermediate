package com.kotlin.samples.kotlinapp.storage

import com.kotlin.samples.kotlinapp.model.UserEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import retrofit2.http.DELETE




object NoteApiClient {

    private val API_BASE_URL = "https://obscure-earth-55790.herokuapp.com"
    private var servicesApiInterface:ServicesApiInterface?=null

    fun build():ServicesApiInterface?{
        var builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor())

        var retrofit: Retrofit = builder.client(httpClient.build()).build()
        servicesApiInterface = retrofit.create(
                ServicesApiInterface::class.java)

        return servicesApiInterface as ServicesApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    interface ServicesApiInterface{

        //https://obscure-earth-55790.herokuapp.com/api/login
        @POST("/api/login")
        fun login(@Body raw:LogInRaw?):Call<LogInResponse>


        //https://obscure-earth-55790.herokuapp.com/api/users/register
        @POST("/api/users/register")
        fun register(@Body raw:UserRaw):Call<UserEntity>

        //https://obscure-earth-55790.herokuapp.com/api/users
        @GET("/api/users/")
        fun users(): Call<UsersResponse>

        //notes
        //https://obscure-earth-55790.herokuapp.com/api/notes
        @GET("/api/notes")
        fun notes(): Call<NotesResponse>

        @POST("/api/notes/register")
        fun addNote(@Body raw: NoteRaw): Call<NoteResponse>

        //update
        @PUT("/api/notes/{id}")
        fun updateNote(@Path("id") noteId: String?, @Body raw: NoteRaw): Call<NoteResponse>

        //delete
        @DELETE("/api/notes/{id}")
        fun deleteNote(@Path("id") noteId: String?): Call<NoteResponse>

    }
}