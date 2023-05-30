package com.example.a21_alert_dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a21_alert_dialog.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogBtn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
                .setTitle("Exit")
                .setIcon(R.drawable.baseline_warning_24)
                //.setPositiveButtonIcon(getDrawable(R.drawable.baseline_warning_24)) //
                .setMessage("Do you want to exit the application?")
                .setPositiveButton("Ok",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        finish()
                    }
                })
                .setNegativeButton("Cancel",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity, "Cancel button clicked",Toast.LENGTH_SHORT).show()

                    }
                })
                .create()
                dialog.show()
        }
    }
}