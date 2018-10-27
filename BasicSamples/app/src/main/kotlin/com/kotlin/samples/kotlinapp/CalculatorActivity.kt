package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_calculator.*


class CalculatorActivity : AppCompatActivity(),View.OnClickListener {

    private var op1=0
    private var op2=0
    private var op=0.0

    companion object {
        const  val TAG="CONSOLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        iviSum.setOnClickListener(this)
        iviSubtract.setOnClickListener(this)
        iviMultiply.setOnClickListener(this)
        iviDivide.setOnClickListener(this)
    }

    override fun onClick( view: View?) {
        Log.v(TAG, "click")

        //TODO capturar valores
        val mOp1= editTextOp1.text.toString()
        val mOp2= editTextOp2.text.toString()
        Log.v(TAG, "mOp1 $mOp1 mOp2 $mOp2")

        //TODO validar campos
        if(mOp1.isEmpty() || mOp2.isEmpty()){
            return
        }

        op1= editTextOp1.text.toString().toInt()
        op2= editTextOp2.text.toString().toInt()

        Log.v(TAG, "op1 $op1 op2 $op2")

        //TODO operaciones
        when(view?.id){
            R.id.iviSum -> op= sumar(op1,op2).toDouble()
            R.id.iviSubtract -> op= restar(op1,op2).toDouble()
            R.id.iviMultiply -> op= multiplicar(op1,op2).toDouble()
            R.id.iviDivide -> op= dividir(op1,op2)
        }
        Log.v(TAG, "op $op")

        //TODO mostrar resultados
        tviOp.text= "Resultado $op"
    }

    private fun sumar(mOp1:Int, mOp2:Int)= mOp1+mOp2
    private fun restar(mOp1:Int, mOp2:Int)= mOp1-mOp2
    private fun multiplicar(mOp1:Int, mOp2:Int)= mOp1*mOp2
    private fun dividir(mOp1:Int, mOp2:Int)= mOp1*1.0/mOp2
}
