package com.example.ageinminutescalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate :TextView? = null
    private var tvAgeinMin :TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    //r.id.btnDatePicker has to be the id of the button itself
        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)  // we have to create btn date picker variable to access the button
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeinMin = findViewById(R.id.tvAgeinMin)

        btnDatePicker.setOnClickListener {
            clickDatepicker()
        }
        //it shows our button is working
        //btnDatePicker.setOnClickListener{
        //    Toast.makeText(this,
        //        "btnDatePicker pressed", Toast.LENGTH_SHORT).show()
        }


     fun clickDatepicker(){

        val myCalendar= Calendar.getInstance()    //to get calendar
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{view, year, month, day ->

            val selectedDate = "$day/${month+1}/$year"
            tvSelectedDate?.setText(selectedDate)

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)

            val selectedDateinMinutes = theDate.time / 60000    //tome=gettime()
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                                          //time that has passed sinch jan 1970 in ms

            val currentDateinMinutes = currentDate.time / 60000
            val differenceInMinutes = currentDateinMinutes - selectedDateinMinutes

            tvAgeinMin?.text = differenceInMinutes.toString()

        },year,month,day
            ).show()

        Toast.makeText(this,
                "btnDatePicker pressed", Toast.LENGTH_SHORT).show()

    }


}