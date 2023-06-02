package com.example.a21_alert_dialog

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a21_alert_dialog.databinding.ActivityDataPickerBinding

class DataPickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataPickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataPickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showDataPickerBtn.setOnClickListener {
            val calendar = Calendar.getInstance() // get today date default
            val datePickerDialog = DatePickerDialog(

                this,
                0,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    binding.selectedDataTv.text = "$year/${month + 1}/$dayOfMonth"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            // calendar data edit to max and min
            calendar.set(Calendar.DAY_OF_MONTH, 18)
            datePickerDialog.datePicker.maxDate = calendar.timeInMillis // show max data
            calendar.set(Calendar.DAY_OF_MONTH, 6)
            datePickerDialog.datePicker.minDate = calendar.timeInMillis // show min data

            datePickerDialog.show()
            datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).text = "Choose" //edit positive button 
        }
    }
}