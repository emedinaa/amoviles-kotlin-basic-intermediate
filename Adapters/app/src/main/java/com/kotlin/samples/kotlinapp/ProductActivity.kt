package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.kotlin.samples.kotlinapp.adapters.ProductListAdapter
import com.kotlin.samples.kotlinapp.data.ProductData
import com.kotlin.samples.kotlinapp.model.Product
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    private var products:List<Product> = emptyList()
    //private var product:List<Product>?=null
    //private lateinit var products:List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        //events
        //listViewProduct.setOnItemClickListener { parent, view, position, id ->
        listViewProduct.setOnItemClickListener { _, _, position, _ ->
            if(!products.isEmpty()){
                val product= products[position]
                showProduct(product)
            }
        }
        /*listViewProduct.setOnItemClickListener(object:AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })*/
        loadProducts()
    }

    private fun  showProduct(product: Product){
        Toast.makeText(this,"product $product",Toast.LENGTH_LONG)
                .show()
    }

    //ProductData().
    private fun loadProducts(){
        products= ProductData.getProductList()

        listViewProduct.adapter=
                ProductListAdapter(this,products)
    }
}
