package com.example.calculatorudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var inputBtn: TextView? = null
    var lastDigit: Boolean = false
    var lastDecimal: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputBtn = findViewById(R.id.input)
    }
    fun onDigit(view: View){
//        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
        inputBtn?.append((view as Button).text)
        lastDigit = true
        lastDecimal = false
    }

    fun onClear(view: View){
        inputBtn?.text = ""
    }

    fun onDecimal(view: View){
        if(lastDigit && !lastDecimal){
            inputBtn?.append(".")
            lastDigit = false
            lastDecimal = true
        }
    }

    fun onOperator(view: View){
        inputBtn?.text?.let {
            if(lastDigit && !isOperatorAdded(it.toString())){
                inputBtn?.append((view as Button).text)
                lastDigit = false
                lastDecimal = false
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean{
        return if(value.startsWith("-")){
            false
        }
        else{
            value.contains("/") || value.contains("*")
                    || value.contains("-") || value.contains("+")
        }
    }

    fun onEqual(view : View){
        if(lastDigit){
            var input = inputBtn?.text.toString()
            var prefix = ""
            try {
                if(input.startsWith("-")){
                    prefix = "-"
                    input = input.substring(1)
                }
                if(input.contains("-")) {
                    var split = input.split("-")
                    var one = split[0]
                    var two = split[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    inputBtn?.text = (one.toDouble() - two.toDouble()).toString()
                }else if(input.contains("+")) {
                    var split = input.split("+")
                    var one = split[0]
                    var two = split[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    inputBtn?.text = (one.toDouble() + two.toDouble()).toString()
                }else if(input.contains("*")) {
                    var split = input.split("*")
                    var one = split[0]
                    var two = split[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    inputBtn?.text = (one.toDouble() * two.toDouble()).toString()
                }else if(input.contains("/")) {
                    var split = input.split("/")
                    var one = split[0]
                    var two = split[1]
                    if(prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    inputBtn?.text = (one.toDouble() / two.toDouble()).toString()
                }
            }catch (e: ArithmeticException){
                e.printStackTrace()
            }

        }
    }
}