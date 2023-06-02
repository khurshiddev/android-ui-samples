package com.example.a21_alert_dialog

import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a21_alert_dialog.databinding.ActivityDataPickerBinding
import com.example.a21_alert_dialog.databinding.ActivityTimePickerBinding

class TimePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimePickerBinding
    private var selectedHour = 0
    private var selectedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val calendar = Calendar.getInstance()
        selectedHour = calendar.get(Calendar.HOUR)
        selectedMinute = calendar.get(Calendar.MINUTE)
        binding.showTimePickerBtn.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    selectedHour = hourOfDay
                    selectedMinute = minute
                    binding.selectedTimeTv.text = "$selectedHour:$selectedMinute"
                },
                selectedHour,
                selectedMinute,
                false  // PM & AM
            )
            timePickerDialog.show()

        }

    }
}