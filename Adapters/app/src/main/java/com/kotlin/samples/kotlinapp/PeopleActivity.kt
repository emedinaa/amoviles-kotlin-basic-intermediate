package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.samples.kotlinapp.adapters.PersonAdapter
import com.kotlin.samples.kotlinapp.data.PeopleData
import kotlinx.android.synthetic.main.activity_people.*

class PeopleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

        //1. Contenedor listView
        //2. Entidad Person
        //3. Origen de datos PeopleData
        //4. Celda XML row_person
        //5. Adapter PersonAdapter
        //6 Setear adapter al ListView

        val personList= PeopleData.getPeopleList()
        val adapter= PersonAdapter(this,personList)
        listView.adapter= adapter
    }
}
