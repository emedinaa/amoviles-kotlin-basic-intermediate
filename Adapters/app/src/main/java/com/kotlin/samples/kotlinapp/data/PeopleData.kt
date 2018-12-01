package com.kotlin.samples.kotlinapp.data

import com.kotlin.samples.kotlinapp.model.Person


/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
object PeopleData {

    fun getPeopleList():List<Person>{
        val mList:MutableList<Person> = arrayListOf()
        mList.add(Person("Eduardo", "emedinaa",0))
        mList.add(Person("José", "jose123",0))
        mList.add(Person("Pablo", "pablo",0))
        mList.add(Person("Item", "subtitle",0))
        mList.add(Person("Eduardo", "emedinaa",0))
        mList.add(Person("Eduardo", "emedinaa",0))

        return mList.toList()
    }
}