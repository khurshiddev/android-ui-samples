package com.example.a21_alert_dialog


import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.DialogInterface.OnMultiChoiceClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a21_alert_dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val checkedList = BooleanArray(3) // bu shu checked listni o'zida save qiladi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogBtn.setOnClickListener {
            val list = arrayOf("Firs", "Second", "Third")
            val dialog = AlertDialog.Builder(this)
                .setTitle("Choose one")
                .setCancelable(false) // bu ekranni boshqa joyini bosganda chiqib ketmasili uchun
                .setMultiChoiceItems(list, checkedList,object : OnMultiChoiceClickListener{
                    override fun onClick(dialog: DialogInterface?, position: Int, isChecked: Boolean) {
                        Log.d("dialog","$position is $isChecked")
                        checkedList[position] = isChecked  // bu qaysi biri checked bo'ganini save qilib turadi
                    }
                })
                .setPositiveButton("OK") { _, _ -> }
                .setNegativeButton("CANCEL") { _, _ -> }
                .create()
            dialog.show()
        }
    }
}