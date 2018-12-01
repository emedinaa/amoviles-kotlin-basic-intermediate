package com.kotlin.samples.kotlinapp.data

import com.kotlin.samples.kotlinapp.model.Person
import com.kotlin.samples.kotlinapp.model.Product


/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
object ProductData {

    fun getProductList():List<Product>{
        val mList:MutableList<Product> = arrayListOf()
        mList.add(Product("Lapicero", 1.0,10,0))
        mList.add(Product("Borrador", 0.5,10,0))
        mList.add(Product("Folders", 1.5,10,0))
        mList.add(Product("Cuadernos", 2.0,10,0))
        mList.add(Product("Tajador", 0.5,10,0))
        mList.add(Product("Hojas Bond", 1.5,10,0))
        mList.add(Product("Tajador", 0.5,10,0))
        mList.add(Product("Tajador", 0.5,10,0))

        return mList.toList()
    }
}