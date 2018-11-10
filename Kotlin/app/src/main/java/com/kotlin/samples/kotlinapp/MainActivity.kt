package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.kotlin.samples.kotlinapp.model.Adult
import com.kotlin.samples.kotlinapp.model.Person
import com.kotlin.samples.kotlinapp.model.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //events
        button.setOnClickListener {

            /*val persona= Persona(0,"Eduardo","Medina",
                    "abc@abc.com",35)

            Log.v("CONSOLE","persona.id ${persona.id}")
            val id= persona.id //lectura
            //persona.id= 20 val
            persona.id=20 //var

            val name= persona.nombre
            //val email= persona.email
            Log.v("CONSOLE","persona.id ${persona.id}")
            Log.v("CONSOLE","persona.nombre ${persona.nombre}")*/
            createEntity()
            //showMessage("Hello Kotlin!")
        }
    }

    private fun createEntity(){
        val name= editTextName.text.toString()
        val lastName= editTextLastName.text.toString()
        val email= editTextEmail.text.toString()
        val age= editTextAge.text.toString()

        val student= Student(0,name,lastName,email,age.toInt())
        /*val student2= Student(0, "Eduardo","Medina","abc@abc.com",
                35)*/
        val person= Person(0,name,lastName,email,age.toInt())
        Log.v("CONSOLE","student name ${student.name} lastName ${student.lastName}")
        student.id=10

        Toast.makeText(this,"Student ${student.toString()}",Toast.LENGTH_LONG).show()
        //Toast.makeText(this,"Person ${person.toString()}",Toast.LENGTH_SHORT).show()

        Log.v("CONSOLE","student name ${student.toString()} lastName ${student.lastName}")

    }

    private fun showMessage(message:String){
        Log.v("CONSOLE",message)

        //val result = double(2)
    }

    private fun tmp(){

        val adult1 = Adult("John")
        val adult2 = Adult("John")
        adult1.age = 10
        adult2.age = 20
    }

    fun double(x: Int): Int {
        return 2 * x
    }

}
