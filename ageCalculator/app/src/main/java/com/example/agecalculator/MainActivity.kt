package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var selecteddate: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        selecteddate = findViewById(R.id.selectedDate)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }
    private fun clickDatePicker(){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{ view, year,month,dayoFmonth ->
            Toast.makeText(this,"Completed!!",Toast.LENGTH_LONG).show()
            val selectedDateString = "$dayoFmonth/${month+1}/$year"
            selecteddate?.text = selectedDateString
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDateString)
            theDate?.let {
                val dateInMinutes = theDate.time / 60000
                val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentdate?.let {
                    val currentMinutes = currentdate.time / 60000
                    val diff = currentMinutes - dateInMinutes
                    val minutes: TextView = findViewById(R.id.minutes)
                    minutes.text = diff.toString()
                }
            }
        },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()
    }
}